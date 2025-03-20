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
            // Arrange
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
            assertThrows(BinarySearchTreeException.class, () -> bst.maximum());
        }

        @Test
        @DisplayName("throws BinarySearchTreeException when minimum")
        void throwsExceptionWhenMinimum() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, () -> bst.minimum());
        }

        @Test
        @DisplayName("throws BinarySearchTreeException when removeBranch")
        void throwsExceptionWhenRemoveBranch() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, () -> bst.removeBranch(0));
        }

        @Test
        @DisplayName("contains returns false")
        void containsReturnsFalse() {
            // Act + Assert
            assertFalse(bst.contains(0));
        }

        @Nested
        @DisplayName("after inserting an element")
        class AfterPushing {

            // Arrange
            int elem = 10;

            @BeforeEach
            void insertAnElement() {
                // Act
                bst.insert(elem);
            }

            @Test
            @DisplayName("size is 1")
            void sizeIsNot0() {
                // Assert
                assertEquals(1, bst.size());;
            }

            @Test
            @DisplayName("depth is 1")
            void depthIsNot0() {
                // Assert
                assertEquals(1, bst.depth());;
            }

            @Test
            @DisplayName("the element is the maximum")
            void elementIsMaximum() {
                // Act + Assert
                assertEquals(elem, bst.maximum());
            }

            @Test
            @DisplayName("the element is the mimimum")
            void elementIsMimimum() {
                // Act + Assert
                assertEquals(elem, bst.minimum());
            }

            @Test
            @DisplayName("contains returns true if the element is present")
            void containsReturnsTrue() {
                // Act + Assert
                assertTrue(bst.contains(elem));
            }

            @Test
            @DisplayName("contains returns false if the element is not present")
            void containsReturnsFalse() {
                // Act + Assert
                assertFalse(bst.contains(0));
            }

            
        }
    }
}
