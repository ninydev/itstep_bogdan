package com.nikstep.helpers.arrays;

/**
 * Класс для работы с простым массивом
 *
 * он должен уметь добалять, удалять именять организацию массива
 * - добавить / удалить в начало / конец
 * - добавить вместе / после нужного элемента
 * - удалить по номеру элемента
 * - + найти минимум, максимум, среднее
 * - + найти первый слева, первый справа  (-1 если не найдено)
 * - + посчитать вхождение
 * - + заменить
 * - + объеденить два массива
 * - + сравнить два массива и выдать одинаковые
 * - + сравнить два массива и выдать отличия
 */


public abstract class ArrayInt {

    /**
     * Вывести на консоль массив, с учетом индексов
     * @param array
     */
    public static void echo(int[] array){
        if (array == null) {
            System.out.print("Array is null\n");
            return;
        }
        for(int i = 0; i < array.length; i++){
            System.out.print("  arr["  + i + "]=" + array[i] );
        }
        System.out.print('\n');
    }

    /**
     * Удаляет элемент с хвоста
     * @param array
     * @return новый массив или null, если такой создать невозможно
     */
    public static int[] popTail(int[] array){
        // я пытаюсь выполнить участок кода
        try {
            if(array.length == 0) {
                System.out.println(" Array size == 0");
                return null;
            }
            int[] newArr = new int[array.length - 1];
            for (int i = 0; i < array.length-1; i++) {
                newArr[i] = array[i];
                return  newArr;
            }
        // Если что то пошло не так - и появилось исключение
        } catch (Exception ex){
            System.out.print(" Exception: " + ex.getMessage());
        }
        return null;
    }

    /**
     * Добавляет элемент массива в начало
     * @param array Массив, который нужно изменить
     * @param value Значение элемента
     * @return Новый массив
     */
    public static int[] pushHead(int[] array, int value){
        // приготовить новое место (область памяти) для операции
        int[] newArr = new int[array.length + 1];
        // размещаю значение в голове массива (перым элементом)
        newArr[0] = value;
        // перемещаю остальные значения
        for (int i = 0; i < array.length; i++) {
            newArr[i + 1] = array[i];
        }
        // возвращаю результат
        return newArr;
    }

    /**
     * Добавляет элемент массива в конец
     * @param array Массив, который нужно изменить
     * @param value Значение элемента
     * @return Новый массив
     */
    public static int[] pushTail(int[] array, int value) {
        // приготовить новое место (область памяти) для операции
        int[] newArr = new int[array.length + 1];
        newArr[newArr.length -1] = value;
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        // обратный порядок
        // for (int i = array.length -1; i >= 0 ; i--) {
        //    newArr[i] = array[i];
        // }

        // возвращаю результат
        return newArr;
    }

    /**
     * Добавляет элемент перед указанным индексом
     * Тоесть - элемент станет на эту позицию
     * @param array Массив, который нужно изменить
     * @param value Значение элемента
     * @param index Значение индекса
     * @return Новый массив
     */
    public static int[] push(int[] array, int value, int index){
        int[] newArr = new int[array.length + 1];

        /*
        for (int i = 0 ; i < index; i++){
            newArr[i] = array[i];
        }
        newArr[index] = value;
        for (int i = index + 1; i < newArr.length; i++ ){
            newArr[i] = array[i - 1];
        }
        */
        // эквивалентная операция второй части цикла
        //for (int i = index; i < array.length; i++ ){
        //    newArr[i + 1] = array[i];
        //}

        for(int oldA = 0, newA = 0; oldA < array.length; oldA++, newA++){
            // Если я дошел до нужного индекса
            if(oldA == index) {
                newArr[newA] = value;
                newA++;
            }
            newArr[newA] = array[oldA];
        }

        return newArr;
    }


    public static boolean compare(int[] arrayFirst, int[] arraySecond){
        if(arrayFirst.length != arraySecond.length)
            return false;
        for(int i = 0; i < arrayFirst.length; i++){
            if (arrayFirst[i] != arraySecond[i]){
                return false;
            }
        }
        return true;
    }

}
