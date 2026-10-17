package com.gupta._5_serving_workflow;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface QuickCookAgent {
    @SystemMessage("""
                    Suggest one everyday dish for one person.
                    The dish must fit within the requested cooking time and maximum 5 steps.
                    Salt, water and oil are always available.
                    Do not silently treat raw ingredients as precooked.
                    Give a dish name, cooking time, ingredients and steps; no introduction.""")

    @UserMessage("Suggest a meal that can be prepared in {{duration}} minutes.")
    @Agent(description = "Suggests one quick dish within a requested time limit", outputKey = "recipe")
    String suggest(@V("duration") int duration);
}