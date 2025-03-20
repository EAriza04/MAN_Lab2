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
        @DisplayName("throws BinarySearchTreeException when isLeaf")
        void elementsAreLeaves() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, () -> bst.isLeaf());;
        }

        @Test
        @DisplayName("contains returns false")
        void containsReturnsFalse() {
            // Act + Assert
            assertFalse(bst.contains(0));
        }

        @Nested
        @DisplayName("after inserting three elements")
        class AfterPushing {

            // Arrange
            int firstElem = 10;
            int secondElem = 20;
            int thirdElem = 5;

            @BeforeEach
            void insertAnElement() {
                // Act
                bst.insert(firstElem);
                bst.insert(secondElem);
                bst.insert(thirdElem);
            }

            @Test
            @DisplayName("size is 3")
            void sizeIsNot0() {
                // Assert
                assertEquals(3, bst.size());;
            }

            @Test
            @DisplayName("depth is 2")
            void depthIsNot0() {
                // Assert
                assertEquals(2, bst.depth());;
            }

            @Test
            @DisplayName("the second element is the maximum")
            void secondElementIsMaximum() {
                // Act + Assert
                assertEquals(secondElem, bst.maximum());
            }

            @Test
            @DisplayName("the third element is the mimimum")
            void thirdeEementIsMimimum() {
                // Act + Assert
                assertEquals(thirdElem, bst.minimum());
            }

            @Test
            @DisplayName("the three is not a leaf")
            void elementsAreLeaves() {
                // Act + Assert
                assertFalse(bst.isLeaf());
            }

            @Test
            @DisplayName("contains returns true if the element is present")
            void containsReturnsTrue() {
                // Act + Assert
                assertTrue(bst.contains(secondElem));
                assertTrue(bst.contains(thirdElem));
            }

            @Test
            @DisplayName("contains returns false if the element is not present")
            void containsReturnsFalse() {
                // Act + Assert
                assertFalse(bst.contains(0));
            }

            @Test
            @DisplayName("throws BinarySearchTreeException when inserting an element that is already in the tree")
            void throwsExceptionWhenInsertDuplicate() {
                // Act + Assert
                assertThrows(BinarySearchTreeException.class, () -> bst.insert(firstElem));
            }

            @Test
            @DisplayName("removeBranch removes the branches successfully")
            void removeBranchRemovesBranches() {
                // Act
                bst.removeBranch(secondElem);
                bst.removeBranch(thirdElem);
                bst.removeBranch(firstElem);
                // Assert
                assertEquals(0, bst.size());
            }

            @Test
            @DisplayName("throws BinarySearchTreeException when removeBranch if the element is not present")
            void throwsExceptionWhenRemoveBranchIsNotPresent() {
                // Act + Assert
                assertThrows(BinarySearchTreeException.class, () -> bst.removeBranch(0));
                assertThrows(BinarySearchTreeException.class, () -> bst.removeBranch(30));
            }

            @Test
            @DisplayName("render returns a representation of the tree")
            void renderReturnsRepresentation() {
                // Act + Assert
                assertEquals("10(5,20)", bst.render());
            }

        }
    }
}
