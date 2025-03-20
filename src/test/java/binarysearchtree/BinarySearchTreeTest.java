// Eduardo Ariza Abad y Enrique Ibáñez Rico

package binarysearchtree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A BinarySearchTree")
class BinarySearchTreeTest {

    BinarySearchTree<Object> bst;

    @Test
    @DisplayName("is instantiated with new BinarySearchTree()")
    void isInstantiatedWithNew() {
        new BinarySearchTree<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewBinarySearchTree() {
            bst = new BinarySearchTree<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(bst.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyBinarySearchTreeException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(EmptyBinarySearchTreeException.class, bst::pop);
        }

        @Test
        @DisplayName("throws EmptyBinarySearchTreeException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(EmptyBinarySearchTreeException.class, bst::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {

            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                bst.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
                assertFalse(bst.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped() {
                assertEquals(anElement, bst.pop());
                assertTrue(bst.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                assertEquals(anElement, bst.peek());
                assertFalse(bst.isEmpty());
            }
        }
    }
}
