package com.gupta._2_recipe_tool;

import dev.langchain4j.service.SystemMessage;

/**
 * Lab 2
 * 
 * FoodOrderAssistant is used to order food at a restaurant.
 * It can answer questions such as:
 * "I want something vegetarian that takes no more than 10 minutes.
 *  What can I order?"
 */

@SystemMessage("""
            You assist customers with the restaurant menu.
            Call the recipes tool before answering each request.
            Recommend only dishes returned by that tool.
            Match the customer's preferences and preparation-time limit.
            If no dish fits, say so.
            Do not invent dishes, prices or availability.
            Do not claim a dish is allergy-safe.
            """)
public interface FoodOrderAssistant {

    String suggest(String request);
}
