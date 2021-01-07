package com.company;

import com.company.arrays.OrdArray;

public class Main {

    public static void main(String[] args) throws Exception {
        OrdArray ordArray = new OrdArray(10);
        ordArray.insert(11);
        ordArray.insert(22);
        ordArray.insert(15);
        ordArray.insert(4);
        ordArray.insert(10);
        ordArray.insert(16);
        ordArray.insert(21);

        System.out.println(ordArray.find(15));

        ordArray.displayArray();

        System.out.println("#############################");
        ordArray.delete(22);
        ordArray.delete(16);
        ordArray.displayArray();

    }
}
