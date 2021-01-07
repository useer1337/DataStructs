package com.company.arrays;

import com.company.exception.ArrayIsEmptyException;
import com.company.exception.ArrayIsFullException;
import com.company.exception.ElementNotFoundException;

/**
 * Упорядоченный массив.
 * С встроенным бинарным поиском.
 *
 * @author koval
 */
public class OrdArray {

    private long[] array;
    private int numberElem;

    public OrdArray(int maxSize) {
        array = new long[maxSize];
        numberElem = 0;
    }

    /**
     * Метод проверяет не полный ли массив.
     *
     * @return правда елси полный, ложь если не полный.
     */
    public boolean isFull() {
        return numberElem == array.length;
    }

    /**
     * Метод проверяет не пустой ли массив.
     *
     * @return правда елси пустой, ложь если не пустой.
     */
    public boolean isEmpty() {
        return numberElem == 0;
    }

    /**
     * Метод для вставки значений в упорядоченный массив.
     * Поиск места для вставки реалитзован с помощью алгоритма "Бинарный поиск".
     *
     * @param value занчение которое будет вставляться в массив.
     * @throws ArrayIsFullException исключение при переполнении массива.
     */
    public void insert(long value) throws ArrayIsFullException {
        if (isFull())
            throw new ArrayIsFullException("Array is full. The number of elements is: " + numberElem);

        int left = 0;
        int right = numberElem - 1;
        int previousCenter = 0;
        int center = 0;

        if (!isEmpty()) {
            while (true) {
                previousCenter = center;
                center = (left + right) / 2;
                if (left > right) {
                    if (array[previousCenter] < value) {
                        previousCenter += 1;
                        break;
                    }
                    break;
                }
                if (array[center] < value) {
                    left = center + 1;
                } else right = center - 1;
            }
        }

        for (int end = numberElem - 1; end >= previousCenter; end--) {
            array[end + 1] = array[end];
        }
        array[previousCenter] = value;
        numberElem += 1;
    }

    /**
     * Удаляет элемент из массива.
     * Поиск удаляемого елемента реалитзован с помощью алгоритма "Бинарный поиск".
     *
     * @param value значение элеемнта который нужно удалить.
     * @return удаленный элемент.
     * @throws ArrayIsEmptyException    кидается при попытки удалить элемент из пустого массива.
     * @throws ElementNotFoundException кидается когда элемент не найден.
     */
    public long delete(long value) throws ArrayIsEmptyException, ElementNotFoundException {
        if (isEmpty())
            throw new ArrayIsEmptyException("Array is empty. Why are you trying to remove from it?");

        int center;
        int left = 0;
        int right = numberElem - 1;

        while (true) {
            center = (left + right) / 2;
            if (array[center] == value) {
                break;
            }
            if (left > right)
                throw new ElementNotFoundException("The item you are looking for is not here");
            if (array[center] < value) {
                left = center + 1;
            } else right = center - 1;
        }
        long temp = array[center];
        for (int end = center; end < numberElem; end++) {
            array[end] = array[end + 1];
        }
        numberElem -= 1;
        return temp;
    }

    /**
     * Метод для поиска элементов в массиве.
     * Поиск осуществлятся через алгоритм "Бинарный поиск".
     *
     * @param value значение елемента которые мы ищем.
     * @return елемент который мы нашли.
     * @throws ElementNotFoundException кидается когда элемент не найден.
     */
    public long find(long value) throws ElementNotFoundException {
        int center;
        int left = 0;
        int right = numberElem - 1;

        while (true) {
            center = (left + right) / 2;
            if (array[center] == value)
                return array[center];
            if (left > right)
                throw new ElementNotFoundException("The item you are looking for is not here");
            if (array[center] < value) {
                left = center + 1;
            } else right = center - 1;
        }
    }

    /**
     * Вывод масссива.
     */
    public void displayArray() {
        for (int i = 0; i < numberElem; i++)
            System.out.println(array[i]);
    }

}
