package com.gupta._2_recipe_tool.version2;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.exception.ToolErrorVisibleToLlm;

public class MenuToolV2 {

    @Tool("Returns the complete local recipe catalogue. Call this before recommending a recipe; do not invent catalogue entries.")
    public String recipes() {

        System.out.println("[Java tool] Reading local recipe catalogue");

        try {
            return loadRecipes();
        } catch (Exception e) {
            throw ToolErrorVisibleToLlm.from(
                    "The local recipe catalogue is temporarily unavailable. Please tell the user you cannot recommend a dish right now."
            );
        }
    }

    private String loadRecipes() {
        return """
                Cucumber yogurt bowl | 5 minutes | cucumber, yogurt | Chop cucumber; stir into yogurt with a little salt.
                Chickpea salad | 10 minutes | cooked chickpeas, cucumber, tomato | Chop vegetables; mix with drained cooked chickpeas and a little salt and oil.
                P's Special Tomato cheese toast | 10 minutes | bread, tomato, cheese | Put sliced tomato and cheese on bread; toast in a pan until the cheese melts.
                Egg toast | 10 minutes | egg, bread | Beat egg; cook in an oiled pan until set; serve on toasted bread.
                """;
    }
}