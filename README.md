1)  I pledge the highest level of ethical principles in support of academic excellence. 
    I ensure that all of my work reflects my own abilities and not those of someone else.
    
2)  Saying we want to add a cool feature - button "x" to run multiplication.
    What code do we need to change/add/remove to support this feature?
    Which tests can we run on the calculator? On the activity? On the app?  
    
    Answer - first of all we need to add a "multi" button, so we can support this feature.
    Then, we'll need to add the logic parts to support this action - we'll add a
    insertMulti() method to the simpleCalculator interface and implement it in simpleCalculatorImpl.
    The implementation will be the same as rest of the operations, where using the multi operation
    on an empty output will yield "0x".We'll have to change(add new feature to) the logic behind 
    transforming a string(the input) to a finite number(the output) to support the multi operation.
    After we'll create the logic we need to connect our logic part to the correspond UI button
    (the 'x' button'). Then we'll need to update the onCreate() method to initial the multi button.
    There is no need to delete/remove any existing code from our program in order to support the multi
     operation.
    
    We can run the same exact tests as before on our new calculator, but in order to test our new multi
    feature we will have to write new additional tests, and to add the 'x' operation to the relevant 
    existing test. The new tests will only focus on the logical part of the multiplication operation. 
    WE'll write a new test for the multi button in the main activity to check that it works as expected
    when pressed. Finally we'll write new test and editing existing tests to check the app flow after
    we added our new feature, thus making sure that the new feature did not massed up our application,
    and is working as it should.     