package a_revision;

public class WorkingWithArraysExamples {
    public static void main(String[] args) {
        /*
            CREATING AN ARRAY
            Syntax:
                typeName [] arrayName = new typeName [Size you need the array to be]
            OR
                typeName [] arrayName = { data you want in the array, separated by commas }
        */
        // Create an array of ints with 5 EMPTY slots
        int [] unknownIntData = new int[5];
        // Create an array that contains SPECIFIC values
        int [] knownIntData = {1, 2, 3, 4, 5};

        // Create an array of Strings with 5 EMPTY slots
        String [] unknownStringData = new String[5];
        // Create an array that contains SPECIFIC values
        String [] knownStringData = {"A", "B", "C", "D", "E"};

        /*
            FINDING THE SIZE OF AN ARRAY
            Syntax: arrayName.length
            Note: length isn't a method name, so no round brackets () appear after it!
        */
        // Using it indirectly - putting it in a variable, then using the variable
        int knownDataSize = knownIntData.length;
        System.out.printf("There are %d slots in the known int data array.\n", knownDataSize);
        // You can also use it directly:
        System.out.printf("There are %d slots in the unknown int data array.\n", unknownIntData.length);

        /*
            ACCESSING AN ARRAY
            Syntax: arrayName[positionToAccess]
        */
        System.out.println("Displaying the contents of knownIntData using println:");
        for (int i = 0; i < knownIntData.length; i++){
            System.out.println(i+": "+knownIntData[i]);
        }
        System.out.println("Displaying the contents of knownStringData using printf:");
        for (int i = 0; i < knownStringData.length; i++){
            System.out.printf("%d: %s \n", i, knownStringData[i]);
        }

        /*
            CHANGING THE CONTENTS OF AN ARRAY SLOT
            Syntax: arrayName[positionToAccess] = what you want to put in it
            Note: This will OVERWRITE what was in the position/slot already
        */
        System.out.println("Inserting data into the unknownStringData array");
        for (int i = 0; i < unknownStringData.length; i++) {
            // Setting the current slot (slot i) in the unknownStringData array to be "Hello"
            unknownStringData[i] = "Hello";
        }
        System.out.println("Displaying the contents of unknownStringData using println:");
        for (int i = 0; i < unknownStringData.length; i++){
            System.out.println(i+": "+unknownStringData[i]);
        }

        System.out.println("Deleting/Overwriting slot 3 of the unknownStringData array:");
        unknownStringData[3] = "Not hello.";

        System.out.println("Displaying the contents of unknownStringData using println:");
        for (int i = 0; i < unknownStringData.length; i++){
            System.out.println(i+": "+unknownStringData[i]);
        }
    }
}
