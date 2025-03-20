// Eduardo Ariza Abad y Enrique Ibáñez Rico

package binarysearchtree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A BinarySearchTree")
class BinarySearchTreeTest {

    BinarySearchTree<Integer> bst;

    @Test
    @DisplayName("is instantiated with new BinarySearchTree()")
    void isInstantiatedWithNew() {
        new BinarySearchTree<Integer>(Comparator.naturalOrder());
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewBinarySearchTree() {
            bst = new BinarySearchTree<Integer>(Comparator.naturalOrder());
        }

        @Test
        @DisplayName("size is 0")
        void sizeIs0() {
            // Arrange
            int expectedSize = 0;
            // Act + Assert
            assertEquals(expectedSize, bst.size());
        }

        @Test
        @DisplayName("depth is 0")
        void depthIs0() {
            // Arrange
            int expectedDepth = 0;
            // Act + Assert
            assertEquals(expectedDepth, bst.depth());
        }

        @Test
        @DisplayName("throws BinarySearchTreeException when maximum")
        void throwsExceptionWhenMaximum() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, bst::maximum);
        }

        @Test
        @DisplayName("throws BinarySearchTreeException when minimum")
        void throwsExceptionWhenMinimum() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, bst::minimum);
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
