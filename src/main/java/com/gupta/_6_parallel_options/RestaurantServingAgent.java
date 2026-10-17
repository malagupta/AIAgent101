package com.gupta._6_parallel_options;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface RestaurantServingAgent {
    @UserMessage("""
            
            Recipe:
            {{recipe}}

            Suggest a restaurant-style way to serve this dish.
            Recommend suitable tableware or serving ware such as a shallow bowl, slate plate,
            small platter, ramekin, soup bowl, or wide-rimmed plate.
            Make it sound slightly polished, but still realistic.

            Return the response in this format:

            Dish:
            <repeat the recipe name or short dish description>

            Restaurant serving:
            <your recommendation with one short reason>
            <><><><><><><><><><><><><><><><><><><><><><>
            
            """)

    @Agent(description = "Suggests a restaurant-style serving option", outputKey = "restaurantServing")
    String suggest(@V("recipe") String recipe);
}