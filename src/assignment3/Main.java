package assignment3;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private boolean increasing;

    private void eval(String input){
        Scanner s = new Scanner(input);
        s.useDelimiter("");
        BST bst = new BST<>();
        increasing = true;

        bst = parseOptions(s,bst);
        Iterator<Identifier> result = sort(bst);

        while(result.hasNext()){
            System.out.println(result.next().get());
        }
    }

    private Iterator sort(BST bst){
        if(increasing){
            return bst.ascendingIterator();
        } else {
            return bst.descendingIterator();
        }
    }

    private BST parseOptions(Scanner s, BST bst){
        skipSpaces(s);
        if(nextCharIs(s,'-')){
            nextChar(s);
            if(nextCharIs(s,'i')){
                nextChar(s);
                s = new Scanner(s.nextLine().toLowerCase());
                s.useDelimiter("");
                return parseOptions(s,bst);
            }
            if (nextCharIs(s,'d')){
                nextChar(s);
                increasing = false;
                parseOptions(s,bst);
                return bst;
            }
        }
        return parseFiles(s,bst);
    }

    private BST parseFiles(Scanner s,BST bst){
        if(nextCharIsLetter(s)){
            Identifier id = new Identifier();
            id.add(nextChar(s));
            parseFile(s,id);
            checkEvenOrUneven(bst,id);
            parseFiles(s,bst);
        } else if (nextCharIsDigit(s)){
            nextChar(s);
            parseFiles(s,bst);
        } else if (s.hasNext()){
            nextChar(s);
            parseFiles(s,bst);
        }
        return bst;
    }

    private void checkEvenOrUneven(BST bst, Identifier id){
        if(bst.find(id)){
            bst.delete(id);
        } else {
            bst.insert(id);
        }
    }

    private Identifier parseFile(Scanner s, Identifier id){
        if(nextCharIsDigit(s) || nextCharIsLetter(s)){
            id.add(nextChar(s));
            parseFile(s,id);
        }
        return id;
    }

    private void start(String[] args) {
        StringBuffer sb = new StringBuffer();
        for(String line : args){
            sb.append(" ").append(line);
        }
        eval(sb.toString());
    }

    private char nextChar(Scanner in) {
        return in.next().charAt(0);
    }

    private boolean nextCharIs(Scanner in,char c) {
        return in.hasNext(Pattern.quote(c + ""));
    }

    private boolean nextCharIsDigit(Scanner in) {
        return in.hasNext("[0-9]");
    }

    private boolean nextCharIsLetter(Scanner in) {
        return in.hasNext("[a-zA-Z]");
    }

    private void skipSpaces(Scanner s){
        while(nextCharIs(s, ' ')) {
            nextChar(s);
        }
    }

    public static void main(String[] args) {
        new Main().start(args);
    }
}
