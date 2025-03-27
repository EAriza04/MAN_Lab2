// Eduardo Ariza Abad y Enrique Ibáñez Rico

package binarysearchtree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A BinarySearchTree")
class BinarySearchTreeTest {

    BinarySearchTree<Integer> bst;

    @Test
    @DisplayName("is instantiated with new BinarySearchTree()")
    void new_instantiatesTree() {
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
        void size_EmptyTree_ReturnsZero() {
            // Arrange
            int expectedSize = 0;

            // Act + Assert
            assertEquals(expectedSize, bst.size());
        }

        @Test
        @DisplayName("depth is 0")
        void depth_EmptyTree_ReturnsZero() {
            // Arrange
            int expectedDepth = 0;

            // Act + Assert
            assertEquals(expectedDepth, bst.depth());
        }

        @Test
        @DisplayName("throws BinarySearchTreeException when maximum")
        void maximum_EmptyTree_ThrowsBSTException() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, () -> bst.maximum());
        }

        @Test
        @DisplayName("throws BinarySearchTreeException when minimum")
        void minimum_EmptyTree_ThrowsBSTException() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, () -> bst.minimum());
        }

        @Test
        @DisplayName("throws BinarySearchTreeException when removeBranch")
        void removeBranch_EmptyTree_ThrowsBSTException() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, () -> bst.removeBranch(0));
        }

        @Test
        @DisplayName("throws BinarySearchTreeException when isLeaf")
        void isLeaf_EmptyTree_ThrowsBSTException() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, () -> bst.isLeaf());;
        }

        @Test
        @DisplayName("contains returns false")
        void contains_EmptyTree_ReturnsFalse() {
            // Act + Assert
            assertFalse(bst.contains(0));
        }

        @Test
        @DisplayName("render returns an empty string")
        void render_EmptyTree_ReturnsEmptyString() {
            // Act + Assert
            assertEquals("", bst.render());
        }

        @Test
        @DisplayName("inOrder returns an empty list")
        void inOrder_EmptyTree_ReturnsEmptyList() {
            // Act + Assert
            assertTrue(bst.inOrder().isEmpty());
        }

        @Test
        @DisplayName("throws BinarySearchTreeException when removeValue if the tree is empty")
        void removeValue_ElementNotPresent_ThrowsBSTException() {
            // Act + Assert
            assertThrows(BinarySearchTreeException.class, () -> bst.removeValue(0));
        }

        @Nested
        @DisplayName("after inserting five elements")
        class AfterInserting {

            // Arrange
            int firstElem = 10;
            int secondElem = 20;
            int thirdElem = 5;
            int fourthElem = 3;
            int fifthElem = 30;

            @BeforeEach
            void insertElements() {
                // Act
                bst.insert(firstElem);
                bst.insert(secondElem);
                bst.insert(thirdElem);
                bst.insert(fourthElem);
                bst.insert(fifthElem);
            }

            @Test
            @DisplayName("size is 5")
            void size_TreeWithFiveElements_ReturnsFive() {
                // Act + Assert
                assertEquals(5, bst.size());;
            }

            @Test
            @DisplayName("depth is 3")
            void depth_TreeWithDepthThree_ReturnsThree() {
                // Act + Assert
                assertEquals(3, bst.depth());;
            }

            @Test
            @DisplayName("the fifth element is the maximum")
            void maximum_TreeWithFiveElements_ReturnsMaximum() {
                // Act + Assert
                assertEquals(fifthElem, bst.maximum());
            }

            @Test
            @DisplayName("the fourth element is the mimimum")
            void minimum_TreeWithFiveElements_ReturnsMinimum() {
                // Act + Assert
                assertEquals(fourthElem, bst.minimum());
            }

            @Test
            @DisplayName("the tree is not a leaf")
            void isLeaf_TreeWithFiveElements_ReturnsFalse() {
                // Assert
                assertFalse(bst.isLeaf());
            }

            @Test
            @DisplayName("the tree is a leaf")
            void isLeaf_TreeWithOneElement_ReturnsTrue() {
                // Act
                bst.removeBranch(secondElem);
                bst.removeBranch(thirdElem);

                // Assert
                assertTrue(bst.isLeaf());
            }

            @Test
            @DisplayName("contains returns true if the element is present")
            void contains_ElementInTheTree_ReturnsTrue() {
                // Act + Assert
                assertTrue(bst.contains(secondElem));
                assertTrue(bst.contains(thirdElem));
            }

            @Test
            @DisplayName("contains returns false if the element is null or not present")
            void contains_ElementNotInTheTree_ReturnsFalse() {
                // Act + Assert
                assertFalse(bst.contains(null));
                assertFalse(bst.contains(0));
            }

            @Test
            @DisplayName("throws BinarySearchTreeException when inserting an element that is already in the tree")
            void insert_ElementAlreadyInTree_ThrowsBSTException() {
                // Act + Assert
                assertThrows(BinarySearchTreeException.class, () -> bst.insert(firstElem));
            }

            @Test
            @DisplayName("removeBranch removes the branches successfully")
            void removeBranch_NotEmptyTree_RemovesBranchesSuccessfully() {
                // Act
                bst.removeBranch(fourthElem);
                bst.removeBranch(fifthElem);
                bst.removeBranch(thirdElem);
                
                // Assert
                assertFalse(bst.isLeaf());
                assertFalse(bst.contains(fourthElem));
                assertEquals(2, bst.size());
            }

            @Test
            @DisplayName("removeBranch of root element removes the tree")
            void removeBranch_RootElement_RemovesTree() {
                // Act
                bst.removeBranch(firstElem);
                
                // Assert
                assertEquals(0, bst.size());
            }

            @Test
            @DisplayName("throws BinarySearchTreeException when removeBranch if the element is not present")
            void removeBranch_ElementNotPresent_ThrowsBSTException() {
                // Act + Assert
                assertThrows(BinarySearchTreeException.class, () -> bst.removeBranch(0));
                assertThrows(BinarySearchTreeException.class, () -> bst.removeBranch(50));
            }

            @Test
            @DisplayName("render returns a representation of the tree")
            void render_NotEmptyTree_ReturnsRepresentation() {
                // Act + Assert
                assertEquals("10(5(3,),20(,30))", bst.render());
            }

            @Test
            @DisplayName("inOrder returns a list with the tree elements in order")
            void inOrder_NotEmptyTree_ReturnsOrderedList() {
                // Arrange
                List<Integer> expectedList = List.of(3, 5, 10, 20, 30);

                // Act + Assert
                assertEquals(expectedList, bst.inOrder());
            }

            @Test
            @DisplayName("throws BinarySearchTreeException when removeValue if the element is not present")
            void removeValue_ElementNotPresent_ThrowsBSTException() {

                // Act + Assert
                assertThrows(BinarySearchTreeException.class, () -> bst.removeValue(0));
                assertThrows(BinarySearchTreeException.class, () -> bst.removeValue(50));
            }

            @Test
            @DisplayName("removeValue returns a list with the tree elements in order")
            void removeValue_NotEmptyTree_RemovesValueSuccessfully() {
                // Arrange
                int previousSize = bst.size();
                int valueToRemove1 = 10;
                int valueToRemove2 = 5;
                int valueToRemove3 = 3;
                int valueToRemove4 = 30;
                int valueToRemove5 = 20;

                // Act 
                bst.removeValue(valueToRemove1);
                bst.removeValue(valueToRemove2);
                bst.removeValue(valueToRemove3);
                bst.removeValue(valueToRemove4);
                bst.removeValue(valueToRemove5);

                //Assert
                assertEquals(previousSize-5, bst.size());
            }
  
        }
    }
}
