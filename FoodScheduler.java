// Elvin Latifi

import java.io.*;
import java.util.*;

public class FoodScheduler {
    // Instance variables
    private final ArrayList<Dish> dishes = new ArrayList<>();

    // Constructor
    public FoodScheduler(String fileName) {
        load(fileName);
    }


    // Methods
    public static void main(String[] args) {
        FoodScheduler fs = new FoodScheduler("dishdata.txt");
        fs.createFoodSchedule();
    }
    private void load(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader in = new BufferedReader(fr);

            int nrOfDishes = Integer.parseInt(in.readLine());
            for (int i = 0; i < nrOfDishes; i++) {
                String name = in.readLine();
                String[] ingredients = in.readLine().split(";");
                String type = in.readLine();
                Dish dish = new Dish(name, ingredients, type);
                dishes.add(dish);
            }
            fr.close();
            in.close();
        }
        catch (IOException e) {
            System.out.println("IO-error: " + e.getMessage());
        }
    }

    private void createFoodSchedule() {
        try {
            FileWriter fw = new FileWriter("foodschedule.txt");
            PrintWriter out = new PrintWriter(fw);

            Collections.shuffle(dishes);
            ArrayList<String> seenTypes = new ArrayList<>();
            ArrayList<Dish> chosenDishes = new ArrayList<>();
            Random random = new Random();
            int counter = 1;
            int meatOrChickenCounter = 0;
            int chickenCounter = 0;
            int meatCounter = 0;
            String previousType = "";
            while (chosenDishes.size() < 7) {
                Dish dish = dishes.get(random.nextInt(dishes.size()));
                if (!seenTypes.contains(dish.getType()) || (dish.getType().equals("m") && !(meatOrChickenCounter >= 5)) || (dish.getType().equals("c")) && !(meatOrChickenCounter >= 5)) {
                    if (dish.getType().equals(previousType))
                        continue;
                    if (dish.getType().equals("m")) {
                        if (meatCounter == 3)
                            continue;
                        meatCounter++;
                    }
                    if (dish.getType().equals("c")) {
                        if (chickenCounter == 3)
                            continue;
                        chickenCounter++;
                    }
                    seenTypes.add(dish.getType());
                    out.println(counter + ": " + dish.getName());
                    counter++;
                    chosenDishes.add(dish);
                    dishes.remove(dish);
                    previousType = dish.getType();
                    if (dish.getType().equals("m") || dish.getType().equals("c")) {
                        meatOrChickenCounter++;
                    }
                }
            }
            createShoppingList(chosenDishes);

            fw.close();
            out.close();
        }
        catch (IOException e) {
            System.out.println("IO-error: " + e.getMessage());
        }
    }

    private void createShoppingList(ArrayList<Dish> dishes) {
        try {
            FileWriter fw = new FileWriter("shoppinglist.txt");
            PrintWriter out = new PrintWriter(fw);

            HashSet<String> ingredients = new HashSet<>();
            for (Dish dish : dishes) {
                ingredients.addAll(Arrays.asList(dish.getIngredients()));
            }
            out.println("Shopping list:");
            for (String ingredient : ingredients) {
                out.println(ingredient);
            }

            fw.close();
            out.close();
        }
        catch (IOException e) {
            System.out.println("IO-error: " + e.getMessage());
        }
    }


}

