
public class JvmComprehension {

    // Класс JvmComprehension загружается в систему загрузчиков класса ClassLoader
    // Информация о классе хранится в MetaSpace

    public static void main(String[] args) { // Происходит вызов метода main().
                                             // В это время в StackMemory создается фрейм main().

        int i = 1;                      // 1 Во фрейме main() создается переменная i типа int,
                                        // ей присваивается значение 1.

        Object o = new Object();        // 2 В области памяти Heap (Куча) создается объект Object (new Object()).
                                        // В области памяти StackMemory во фрейме main() создается ссылка Object o,
                                        // которая присваивается объекту Object (Object o = new Object())

        Integer ii = 2;                 // 3 В Heap создается объект типа Integer с присвоенным значением 2.
                                        // Во фрейме main() создается ссылка ii на данный объект в Heap

        printAll(o, i, ii);             // 4 В StackMemory создается фрейм printAll (), куда передаютя ссылки
                                        // o и ii на объекты в Heap и переменная i

        System.out.println("finished"); // 7 В Heap объект типа String cj значением "finished".
                                        // Во фрейм println() передается ссылка на этот объект.

        // Garbage collector периодически собирает объекты из памяти, которые больше не используются.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В Heap создается объект типа Integer со значением 700
                                                    // Во фрейме printAll() создается ссылка uselessVar на этот объект

        System.out.println(o.toString() + i + ii);  // 6 В StackMemory создается фрейм println куда передаются ссылки
                                                    // o и ii на соответствующие объекты в Heap, а также i на int
                                                    // в StackMemory во фрейме main().
                                                    // В StackMemory создается фрейм toString().
    }
}
