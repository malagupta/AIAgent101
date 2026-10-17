package com.gupta._6_parallel_options;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface CasualServingAgent {
    @UserMessage("""
            
            Recipe:
            {{recipe}}

            Suggest a simple home-style way to serve this dish.
            Recommend suitable everyday tableware such as a plate, bowl, small bowl, or platter.
            Keep it practical and casual.

            Return the response in this format:

            Dish:
            <repeat the recipe name or short dish description>

            Casual serving:
            <your recommendation with one short reason>
            -------------------------------------------
            
            """)

    @Agent(description = "Suggests a casual home-style serving option", outputKey = "casualServing")
    String suggest(@V("recipe") String recipe);
}