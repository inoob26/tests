package org.otheralgor.unitTests;

public class Listiner implements IListiner{
    @Override
    public Integer docAdded(Document document) {
        System.out.println("Document added");
        return 1;
    }

    @Override
    public void docDeleted(Document document) {
        System.out.println("Document deleted");
    }
}
