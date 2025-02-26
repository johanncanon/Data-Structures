package com.johanncanon.datastructures.map.TreeMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class GreenGrocerTest {

    private GreenGrocer greenGrocerTest;
    private TreeMap<Fruit, Integer> fruitsTreeMap;
    private Fruit fruitTest1;
    private Fruit fruitTest2;
    private Fruit fruitTest3;
    private Fruit fruitTest4;

    @BeforeEach
    void setUp() {
        fruitTest1 = new Fruit( "Banana", "Yellow" , "Spring" );
        fruitTest2 = new Fruit( "Pineapple", "Orange" , "Summer" );
        fruitTest3 = new Fruit( "Strawberry", "Blue" , "Spring" );
        fruitTest4 = new Fruit( "Apple", "Green" , "Spring" );
        fruitsTreeMap = new TreeMap<>();

        fruitsTreeMap.put( fruitTest1, 192 );
        fruitsTreeMap.put( fruitTest2, 210 );
        fruitsTreeMap.put( fruitTest3, 199 );
        fruitsTreeMap.put( fruitTest4, 297 );

        greenGrocerTest = new GreenGrocer( "CosechaTest", fruitsTreeMap );
    }

    @AfterEach
    void afterEach(){
        fruitsTreeMap = null;
        greenGrocerTest = null;
    }

    @Test
    void testGetLastAndFirstFruitsFieldsOrderedByName() {
        assertEquals( "Green" , greenGrocerTest.getFirstFruitColor() );
        assertEquals( "Apple", greenGrocerTest.getFirstFruitName() );

        var fruitUnitTest = new Fruit( "WaterMellon", "Rose" , "Spring" );
        fruitsTreeMap.put( fruitUnitTest, 100 );

        assertEquals( "Rose", greenGrocerTest.getLastFruitColor() );
        assertEquals( "WaterMellon", greenGrocerTest.getLastFruitName() );
    }


    @Test
    void testGetAllFruitsLessThatSpecificFruit() {
        var fruitUnitTest = new Fruit( "Guayava", "Green" , "Winter" );
        var fruitUnitTest2 = new Fruit( "Cherry", "Earth" , "Autumn" );
        fruitsTreeMap.put( fruitUnitTest, 100 );
        fruitsTreeMap.put( fruitUnitTest2, 200 );

        var treeMapTestResponse = new TreeMap<Fruit, Integer>();
        treeMapTestResponse.put( fruitTest1, 192 );
        treeMapTestResponse.put( fruitTest2, 210 );
        treeMapTestResponse.put( fruitTest4, 297 );
        treeMapTestResponse.put( fruitUnitTest, 100 );
        treeMapTestResponse.put( fruitUnitTest2, 200 );
        var greenGrocerTestResponse = new GreenGrocer( "CosechaTest", treeMapTestResponse );

        assertEquals( treeMapTestResponse, greenGrocerTest.getAllFruitsLessThan( fruitTest3 ) );
    }
}