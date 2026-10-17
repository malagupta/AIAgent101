package com.gupta._3_structured_recipe;

import dev.langchain4j.agent.tool.Tool;

public class MenuTool {

    @Tool("Returns the complete local recipe catalogue. Call this before recommending a recipe; do not invent catalogue entries.")

    public String recipes() {
        System.out.println("[Java tool] Reading local recipe catalogue");
        return """
                    Cucumber yogurt bowl | 5 minutes | cucumber, yogurt | Chop cucumber; stir into yogurt with a little salt.
                    Chickpea salad | 10 minutes | cooked chickpeas, cucumber, tomato | Chop vegetables; mix with drained cooked chickpeas and a little salt and oil.
                    P's Special Tomato cheese toast | 10 minutes | bread, tomato, cheese | Put sliced tomato and cheese on bread; toast in a pan until the cheese melts.
                    Egg toast | 10 minutes | egg, bread | Beat egg; cook in an oiled pan until set; serve on toasted bread.
                    Tomato cucumber sandwich | 5 minutes | bread, tomato, cucumber | Slice tomato and cucumber; place on bread with a little salt; serve fresh.
                    Cheese cucumber sandwich | 5 minutes | bread, cheese, cucumber | Slice cucumber; layer with cheese on bread; toast or serve fresh.
                    Banana yogurt bowl | 5 minutes | banana, yogurt | Slice banana; stir into yogurt; serve chilled.
                    Apple yogurt cup | 5 minutes | apple, yogurt | Chop apple; mix into yogurt; serve chilled.
                    Tomato soup cup | 15 minutes | tomato, water | Chop tomatoes; simmer with water and salt; mash lightly and serve.
                    Cucumber tomato salad | 5 minutes | cucumber, tomato | Chop cucumber and tomato; mix with salt and a little oil.
                    Cheese omelette | 10 minutes | egg, cheese | Beat egg; cook in an oiled pan; add cheese and fold.
                    Tomato omelette | 10 minutes | egg, tomato | Chop tomato; mix with beaten egg; cook in an oiled pan until set.
                    Bread omelette | 10 minutes | egg, bread | Dip bread in beaten egg; cook on both sides in an oiled pan.
                    Chickpea toast | 10 minutes | cooked chickpeas, bread | Mash chickpeas with salt and oil; spread on toasted bread.
                    Chickpea cucumber bowl | 10 minutes | cooked chickpeas, cucumber, yogurt | Chop cucumber; mix with chickpeas and yogurt; add a little salt.
                    Tomato rice | 15 minutes | cooked rice, tomato | Cook chopped tomato with oil and salt; stir in cooked rice and warm through.
                    Egg fried rice | 15 minutes | cooked rice, egg | Scramble egg in oil; add cooked rice and salt; stir until hot.
                    Chickpea rice bowl | 10 minutes | cooked rice, cooked chickpeas | Warm rice and chickpeas together with salt and a little oil.
                    Cucumber rice salad | 10 minutes | cooked rice, cucumber, yogurt | Mix cooked rice with chopped cucumber and yogurt; season lightly.
                    Cheese noodles | 15 minutes | noodles, cheese | Cook noodles; stir in cheese while hot until creamy.
                    Tomato noodles | 15 minutes | noodles, tomato | Cook noodles; warm chopped tomato in oil; mix with noodles.
                    Egg noodles | 15 minutes | noodles, egg | Cook noodles; scramble egg; mix together with salt and a little oil.
                    Lentil soup cup | 15 minutes | cooked lentils, water | Simmer cooked lentils with water and salt; mash lightly and serve.
                    Lentil rice bowl | 10 minutes | cooked lentils, cooked rice | Warm lentils and rice together; season with salt.
                    Paneer tomato toast | 15 minutes | bread, paneer, tomato | Place tomato and paneer on bread; toast in a pan until warm.
                """;
    }
}
