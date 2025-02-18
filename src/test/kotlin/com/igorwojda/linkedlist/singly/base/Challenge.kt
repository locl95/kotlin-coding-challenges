package com.igorwojda.linkedlist.singly.base

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private class SinglyLinkedList<E> {
    var head: Node<E>? = null
    var size: Int = 0
    var first: Node<E>? = null
    var last: Node<E>? = null

    fun insertFirst(v: E): Unit = run {
        if(this.size == 0) this.last = Node(v, null)
        this.size = this.size + 1
        this.head = Node(v, head)
        this.first = Node(v, head)
    }

    fun clear() = run {
        this.head = null
        this.size = 0
        this.first = null
        this.last = null
    }

    fun removeFirst() = run {
        this.first = head?.next
        this.head = head?.next
        this.size = this.size - 1
    }

    fun removeLast(): Nothing = run {
            TODO()
    }
}

private data class Node<T>(
    var data: T,
    var next: Node<T>? = null,
)

private class Test {
    @Test
    fun `when list is created head node is null`() {
        SinglyLinkedList<Int>().apply {
            head shouldBeEqualTo null
        }
    }

    @Test
    fun `append a node to the start of the list`() {
        SinglyLinkedList<Int>().apply {
            insertFirst(1)
            head?.data shouldBeEqualTo 1
            insertFirst(2)
            head?.data shouldBeEqualTo 2
        }
    }

    @Test
    fun `return the number of items in the linked list`() {
        SinglyLinkedList<Int>().apply {
            size shouldBeEqualTo 0
            insertFirst(1)
            insertFirst(1)
            insertFirst(1)
            insertFirst(1)
            size shouldBeEqualTo 4
        }
    }

    @Test
    fun `return the first element`() {
        SinglyLinkedList<Int>().apply {
            insertFirst(1)
            first?.data shouldBeEqualTo 1
            insertFirst(2)
            first?.data shouldBeEqualTo 2
        }
    }

    @Test
    fun `return the last element`() {
        SinglyLinkedList<Int>().apply {
            insertFirst(2)
            last?.data shouldBeEqualTo 2
            last?.next shouldBeEqualTo null
            insertFirst(1)
            last?.data shouldBeEqualTo 2
            last?.next shouldBeEqualTo null
        }
    }

    @Test
    fun `empty the list`() {
        SinglyLinkedList<Int>().apply {
            size shouldBeEqualTo 0
            insertFirst(1)
            insertFirst(1)
            insertFirst(1)
            insertFirst(1)
            size shouldBeEqualTo 4
            clear()
            size shouldBeEqualTo 0
        }
    }

    @Test
    fun `remove the first node when the list has a size of one`() {
        SinglyLinkedList<String>().apply {
            insertFirst("a")
            removeFirst()
            size shouldBeEqualTo 0
            first shouldBeEqualTo null
        }
    }

    @Test
    fun `remove the first node when the list has a size of three`() {
        SinglyLinkedList<String>().apply {
            insertFirst("c")
            insertFirst("b")
            insertFirst("a")
            removeFirst()
            size shouldBeEqualTo 2
            first?.data shouldBeEqualTo "b"
            removeFirst()
            size shouldBeEqualTo 1
            first?.data shouldBeEqualTo "c"
        }
    }
//
//    @Test
//    fun `remove the last node when list is empty`() {
//        SinglyLinkedList<Any>().apply {
//            removeLast()
//        }
//    }
//
//    @Test
//    fun `remove the last node when list is length 1`() {
//        SinglyLinkedList<String>().apply {
//            insertFirst("a")
//            removeLast()
//            head shouldBeEqualTo null
//        }
//    }
//
//    @Test
//    fun `remove the last node when list is length 2`() {
//        SinglyLinkedList<String>().apply {
//            insertFirst("b")
//            insertFirst("a")
//            removeLast()
//            size shouldBeEqualTo 1
//            head?.data shouldBeEqualTo "a"
//        }
//    }
//
//    @Test
//    fun `remove the last node when list is length 3`() {
//        SinglyLinkedList<String>().apply {
//            insertFirst("c")
//            insertFirst("b")
//            insertFirst("a")
//            removeLast()
//            size shouldBeEqualTo 2
//            last?.data shouldBeEqualTo "b"
//        }
//    }
//
//    @Test
//    fun `add to the end of the list`() {
//        SinglyLinkedList<String>().apply {
//            insertFirst("a")
//            insertLast("b")
//            size shouldBeEqualTo 2
//            last?.data shouldBeEqualTo "b"
//        }
//    }
//
//    @Test
//    fun `return the node at given index`() {
//        SinglyLinkedList<Char>().apply {
//            getAt(10) shouldBeEqualTo null
//
//            insertLast('A')
//            insertLast('B')
//            insertLast('C')
//            insertLast('D')
//
//            getAt(0)?.data shouldBeEqualTo 'A'
//            getAt(1)?.data shouldBeEqualTo 'B'
//            getAt(2)?.data shouldBeEqualTo 'C'
//            getAt(3)?.data shouldBeEqualTo 'D'
//            getAt(4)?.data shouldBeEqualTo null
//        }
//    }
//
//    @Test
//    fun `set node data at index 0`() {
//        SinglyLinkedList<String>().apply {
//            insertLast("a")
//            insertLast("b")
//            insertLast("c")
//            setAt("new", 0)
//            getAt(0)?.data shouldBeEqualTo "new"
//            getAt(1)?.data shouldBeEqualTo "b"
//            getAt(2)?.data shouldBeEqualTo "c"
//        }
//    }
//
//    @Test
//    fun `set node data at index 1`() {
//        SinglyLinkedList<String>().apply {
//            insertLast("a")
//            insertLast("b")
//            insertLast("c")
//            setAt("new", 1)
//            getAt(0)?.data shouldBeEqualTo "a"
//            getAt(1)?.data shouldBeEqualTo "new"
//            getAt(2)?.data shouldBeEqualTo "c"
//        }
//    }
//
//    @Test
//    fun `set node data at index 2`() {
//        SinglyLinkedList<String>().apply {
//            insertLast("a")
//            insertLast("b")
//            insertLast("c")
//            setAt("new", 2)
//            getAt(0)?.data shouldBeEqualTo "a"
//            getAt(1)?.data shouldBeEqualTo "b"
//            getAt(2)?.data shouldBeEqualTo "new"
//        }
//    }
//
//    @Test
//    fun `set node data at non existing index`() {
//        SinglyLinkedList<String>().apply {
//            insertLast("a")
//            insertLast("b")
//            insertLast("c")
//            setAt("new", 3)
//            getAt(0)?.data shouldBeEqualTo "a"
//            getAt(1)?.data shouldBeEqualTo "b"
//            getAt(2)?.data shouldBeEqualTo "c"
//        }
//    }
//
//    @Test
//    fun `remove from empty list`() {
//        SinglyLinkedList<Int>().apply {
//            removeAt(0)
//            removeAt(1)
//            removeAt(2)
//        }
//    }
//
//    @Test
//    fun `remove with index out of bounds`() {
//        SinglyLinkedList<String>().apply {
//            insertFirst("a")
//            removeAt(1)
//        }
//    }
//
//    @Test
//    fun `remove the first node`() {
//        SinglyLinkedList<Int>().apply {
//            insertLast(1)
//            insertLast(2)
//            insertLast(3)
//            insertLast(4)
//            getAt(0)?.data shouldBeEqualTo 1
//            removeAt(0)
//            getAt(0)?.data shouldBeEqualTo 2
//        }
//    }
//
//    @Test
//    fun `remove the node at given index`() {
//        SinglyLinkedList<Int>().apply {
//            insertLast(1)
//            insertLast(2)
//            insertLast(3)
//            insertLast(4)
//            getAt(1)?.data shouldBeEqualTo 2
//            removeAt(1)
//            getAt(1)?.data shouldBeEqualTo 3
//        }
//    }
//
//    @Test
//    fun `remove the last node`() {
//        SinglyLinkedList<Int>().apply {
//            insertLast(1)
//            insertLast(2)
//            insertLast(3)
//            insertLast(4)
//            getAt(3)?.data shouldBeEqualTo 4
//            removeAt(3)
//            getAt(3) shouldBeEqualTo null
//        }
//    }
//
//    @Test
//    fun `insert a new node with data at index 0 when the list is empty`() {
//        SinglyLinkedList<String>().apply {
//            insertAt("hi", 0)
//            first?.data shouldBeEqualTo "hi"
//        }
//    }
//
//    @Test
//    fun `insert a new node with data at index 0 when the list has elements`() {
//        SinglyLinkedList<String>().apply {
//            insertLast("a")
//            insertLast("b")
//            insertLast("c")
//            insertAt("hi", 0)
//            getAt(0)?.data shouldBeEqualTo "hi"
//            getAt(1)?.data shouldBeEqualTo "a"
//            getAt(2)?.data shouldBeEqualTo "b"
//            getAt(3)?.data shouldBeEqualTo "c"
//        }
//    }
//
//    @Test
//    fun `insert a new node with data at a middle index`() {
//        SinglyLinkedList<String>().apply {
//            insertLast("a")
//            insertLast("b")
//            insertLast("c")
//            insertLast("d")
//            insertAt("hi", 2)
//            getAt(0)?.data shouldBeEqualTo "a"
//            getAt(1)?.data shouldBeEqualTo "b"
//            getAt(2)?.data shouldBeEqualTo "hi"
//            getAt(3)?.data shouldBeEqualTo "c"
//            getAt(4)?.data shouldBeEqualTo "d"
//        }
//    }
//
//    @Test
//    fun `inserts a new node with data at a last index`() {
//        SinglyLinkedList<String>().apply {
//            insertLast("a")
//            insertLast("b")
//            insertAt("hi", 2)
//            getAt(0)?.data shouldBeEqualTo "a"
//            getAt(1)?.data shouldBeEqualTo "b"
//            getAt(2)?.data shouldBeEqualTo "hi"
//        }
//    }
//
//    @Test
//    fun `insert a new node when index is out of bounds`() {
//        SinglyLinkedList<String>().apply {
//            insertLast("a")
//            insertLast("b")
//            insertAt("hi", 30)
//
//            getAt(0)?.data shouldBeEqualTo "a"
//            getAt(1)?.data shouldBeEqualTo "b"
//            getAt(2)?.data shouldBeEqualTo "hi"
//        }
//    }
//
//    @Test
//    fun `insert a new node to an empty list when index is out of bounds`() {
//        SinglyLinkedList<Int>().apply {
//            insertAt(1, 100)
//            getAt(0)!!.data shouldBeEqualTo 1
//        }
//    }
//
//    @Test
//    fun `sum all the nodes`() {
//        SinglyLinkedList<Int>().apply {
//            insertLast(1)
//            insertLast(2)
//            insertLast(3)
//            insertLast(4)
//
//            sumBy { it.data } shouldBeEqualTo 10
//        }
//    }
//
//    @Test
//    fun `add two empty lists`() {
//        val l1 = SinglyLinkedList<Int>()
//        val l2 = SinglyLinkedList<Int>()
//        val result = l1 + l2
//
//        result.size shouldBeEqualTo 0
//    }
//
//    @Test
//    fun `add two lists`() {
//        val l1 = SinglyLinkedList<Int>().apply {
//            insertLast(1)
//            insertLast(2)
//            insertLast(3)
//        }
//        val l2 = SinglyLinkedList<Int>().apply {
//            insertLast(4)
//            insertLast(5)
//            insertLast(6)
//            insertLast(7)
//        }
//        val result = l1 + l2
//
//        result.apply {
//            size shouldBeEqualTo 7
//            getAt(0)?.data shouldBeEqualTo 1
//            getAt(1)?.data shouldBeEqualTo 2
//            getAt(2)?.data shouldBeEqualTo 3
//            getAt(3)?.data shouldBeEqualTo 4
//            getAt(4)?.data shouldBeEqualTo 5
//            getAt(5)?.data shouldBeEqualTo 6
//            getAt(6)?.data shouldBeEqualTo 7
//        }
//    }
}
