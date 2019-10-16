package assignment3;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private boolean increasing;
    private boolean allowCaps;

    private void start(String[] args) {
        increasing = true;
        allowCaps = true;

        StringBuffer sb = new StringBuffer();
        for(String line : args){
            sb.append(" ").append(line);
        }
        eval(sb.toString());
    }

    private void eval(String input){
        Scanner inputScanner = new Scanner(input);
        inputScanner.useDelimiter("");

        Scanner mergedFiles = getMergedFiles(parseOptions(inputScanner));

        mergedFiles.useDelimiter("");
        BST bst = new BST<>();

        Iterator<Identifier> iterator = sort(parseFiles(mergedFiles, bst));
        while(iterator.hasNext()){
            System.out.println(iterator.next().value());
        }
    }

    private Scanner getMergedFiles(Scanner paths){
        paths.useDelimiter(" ");
        StringBuffer sb = new StringBuffer();
        while(paths.hasNext()){
            sb.append(openFile(paths.next())).append(" ");
        }
        return new Scanner(parseCase(sb.toString()));
    }

    private String openFile(String path){
        try {
            File file = new File(path);
            if(!file.isFile()){
                throw new NoSuchFileException(path);
            }
            return fileToString(file);
        } catch (NoSuchFileException | FileNotFoundException e){
            System.out.println("No file:"+e.getMessage());
            System.exit(1);
        }
        return null;
    }

    private String fileToString(File file) throws FileNotFoundException {
        StringBuffer sb = new StringBuffer();
        Scanner fileScanner = new Scanner(file);
        fileScanner.useDelimiter("");
        while(fileScanner.hasNext()){
            sb.append(nextChar(fileScanner));
        }
        return sb.toString();
    }

    private Iterator sort(BST bst){
        if(increasing){
            return bst.ascendingIterator();
        } else {
            return bst.descendingIterator();
        }
    }

    private Scanner parseOptions(Scanner s){
        nextChar(s);
        skipSpaces(s);
        if(nextCharIs(s,'-')){
            nextChar(s);
            if(nextCharIs(s,'i')){
                nextChar(s);
                allowCaps = false;
                return parseOptions(s);
            }
            if (nextCharIs(s,'d')){
                nextChar(s);
                increasing = false;
                return parseOptions(s);
            }
        }
        return s;
    }

    private BST parseFiles(Scanner s,BST bst){
        if(nextCharIsLetter(s)){
            Identifier id = new Identifier();
            id.add(nextChar(s));
            parseFile(s,id);
            checkEven(bst,id);
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

    private void checkEven(BST bst, Identifier id){
        if(bst.find(id)){
            bst.delete(id);
        } else {
            bst.insert(id);
        }
    }

    private void parseFile(Scanner s, Identifier id){
        if(nextCharIsDigit(s) || nextCharIsLetter(s)){
            id.add(nextChar(s));
            parseFile(s,id);
        }
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

    private String parseCase(String s){
        if(!allowCaps){ return s.toLowerCase();
        } return s;
    }

    public static void main(String[] args) {
        new Main().start(args);
    }
}
