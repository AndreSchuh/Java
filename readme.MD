<!-- TOC -->
* [Projeto de Estudos em Java](#projeto-de-estudos-em-java-)
    * [Manipulação de Mapas](#manipulação-de-mapas)
    * [Collections](#collections)
        * [Principais métodos da interface `Collection`:](#principais-métodos-da-interface-collection)
      * [Subinterfaces de `Collection`](#subinterfaces-de-collection)
        * [1. `List`](#1-list)
          * [Exemplo:](#exemplo)
        * [2. `Set`](#2-set)
          * [Exemplo:](#exemplo-1)
        * [3. `Queue`](#3-queue)
          * [Exemplo:](#exemplo-2)
      * [Comparação Rápida](#comparação-rápida)
      * [Resumo Visual](#resumo-visual)
<!-- TOC -->
# Projeto de Estudos em Java 

Utilização de conceitos básicos na aprendizagem do Java.

- Manipulação de números, BigDecimal.
- Manipulação de Strings, StringBuilder.
- Manipulação de Matrizes.
- Manipulação de Mapas.
- Manipulação de Listas (List: ArrayList, LinkedList).
- Manipulação de Conjuntos (Set: HashSet, TreeSet).
- Manipulação de Streams.
- Lambda Expressions.
- Manipulação de Arquivos.
- Regex
- Manipulação de Datas.
- Objetos e Classes.
- Herança e Polimorfismo.
- Interfaces.
- Exceções.
- Lombok


### Manipulação de Mapas

Sure, let's go over the differences between the three main types of maps in Java: HashMap, TreeMap, and LinkedHashMap.

- HashMap:

  - Performance: HashMap provides constant-time performance O(1) for basic operations like get() and put() assuming the hash function distributes the elements properly among the buckets.
  - Ordering: The order of elements is not guaranteed. It does not maintain any order of its elements.
  - Iteration: The iteration order may change over time due to rehashing or resizing of the underlying array.
  - Implementation: It uses a hash table data structure to store key-value pairs. Keys are hashed to determine the index of the bucket where the entry should be stored.
  - Usage: HashMap is a general-purpose map implementation suitable for most use cases where order is not important.

- TreeMap:

  - Performance: TreeMap provides guaranteed log(n) time complexity for basic operations like get(), put(), and remove(), where n is the number of elements in the map.
  - Ordering: TreeMap maintains the elements in ascending order of their keys. It uses the natural ordering of keys or a comparator provided at the time of creation.
  - Iteration: Iteration over a TreeMap is in sorted order based on the keys.
  - Implementation: It is implemented as a Red-Black tree structure. Each node in the tree stores a key-value pair.
  - Usage: TreeMap is suitable when you need a sorted map or when you want to iterate over the keys in sorted order.

- LinkedHashMap:

  - Performance: LinkedHashMap provides constant-time performance O(1) for basic operations like get() and put(). However, the constant factor is higher compared to HashMap due to maintaining the linked list.
  - Ordering: LinkedHashMap maintains the insertion order of elements. When iterating over the elements, they are returned in the order they were inserted.
  - Iteration: Iteration over a LinkedHashMap is in the order of insertion.
  - Implementation: It combines a hash table with a doubly-linked list to maintain the order of insertion.
  - Usage: LinkedHashMap is useful when you need to maintain the order in which elements were inserted or when you want to iterate over the elements in insertion order.

  > **In summary, choose HashMap when order doesn't matter and you want better performance, TreeMap when you need elements sorted by their keys, and LinkedHashMap when you want to maintain the order of insertion. Each type has its own trade-offs in terms of performance and ordering guarantees.**


### Collections

A interface `Collection` é a raiz da hierarquia de coleções no Java Collections Framework. Ela define as operações básicas que todas as coleções devem implementar, como adicionar, remover, verificar a presença de elementos e obter o tamanho da coleção.

##### Principais métodos da interface `Collection`:
- `boolean add(E e)`: Adiciona um elemento à coleção.
- `boolean remove(Object o)`: Remove um elemento da coleção.
- `boolean contains(Object o)`: Verifica se a coleção contém o elemento especificado.
- `int size()`: Retorna o número de elementos na coleção.
- `void clear()`: Remove todos os elementos da coleção.
- `boolean isEmpty()`: Verifica se a coleção está vazia.
- `Iterator<E> iterator()`: Retorna um iterador sobre os elementos da coleção.

#### Subinterfaces de `Collection`

##### 1. `List`
Uma coleção ordenada que permite elementos duplicados. As listas mantêm a ordem de inserção dos elementos.

**Implementações Comuns:**
- `ArrayList`: Baseada em array, eficiente para acesso e iteração.
- `LinkedList`: Baseada em nós encadeados, eficiente para inserções e remoções.

###### Exemplo:
```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("C");
```

##### 2. `Set`
Uma coleção que não permite elementos duplicados. A interface `Set` não garante nenhuma ordem específica dos elementos.

**Implementações Comuns:**
- `HashSet`: Baseada em hash table, eficiente para operações básicas.
- `LinkedHashSet`: Mantém a ordem de inserção.
- `TreeSet`: Mantém os elementos ordenados.

###### Exemplo:
```java
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
set.add("A"); // Elemento duplicado, não será adicionado
```

##### 3. `Queue`
Uma coleção usada para manter elementos antes do processamento. Normalmente segue a ordem FIFO (First-In-First-Out).

**Implementações Comuns:**
- `LinkedList`: Também implementa `Queue`, além de `List`.
- `PriorityQueue`: Mantém os elementos ordenados de acordo com a prioridade natural ou um comparador fornecido.

###### Exemplo:
```java
Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");
queue.add("C");
String head = queue.poll(); // Retira e retorna o primeiro elemento (FIFO)
```

#### Comparação Rápida

- **`List`**: Permite duplicados, mantém a ordem de inserção.
- **`Set`**: Não permite duplicados, pode ou não manter uma ordem específica.
- **`Queue`**: Foca em enfileiramento e desenfileiramento, geralmente segue FIFO ou ordem de prioridade.

#### Resumo Visual

- **`Collection`**
  - **`List`**
    - `ArrayList`
    - `LinkedList`
  - **`Set`**
    - `HashSet`
    - `LinkedHashSet`
    - `TreeSet`
  - **`Queue`**
    - `LinkedList`
    - `PriorityQueue`

Cada uma dessas subinterfaces de `Collection` é projetada para diferentes cenários de uso, oferecendo diversas implementações para atender às necessidades específicas de desempenho, ordenação e manipulação de elementos.