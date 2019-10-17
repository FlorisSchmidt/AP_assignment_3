package assignment3;

import java.lang.StringBuffer;

public class Identifier implements IdentifierInterface, Comparable<Identifier> {

    private StringBuffer sb;
    private boolean addWasCalled;

    Identifier(){
        sb = new StringBuffer();
        init();
    }

    Identifier(Identifier src){
        sb = new StringBuffer();
        addWasCalled = src.addWasCalled;
        sb.append(src.value());

    }

    @Override
    public void init() {
        sb.delete(0,sb.length());
        sb.append('c');
        addWasCalled = false;
    }

    @Override
    public boolean add(char c){
        if(addWasCalled) {
            sb.append(c);
        } else {
            sb.delete(0, 1);
            sb.append(c);
            addWasCalled = true;
        }
        return true;
    }

    @Override
    public String value() {
        return sb.toString();
    }

    @Override
    public int size() {
        return sb.length();
    }

    @Override
    public boolean equals(Identifier comparand) {
        return this.value().equals(comparand.value());
    }

    @Override
    public int compareTo(Identifier o) {
        return value().compareTo(o.value());
    }

}
