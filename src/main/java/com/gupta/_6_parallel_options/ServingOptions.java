package com.gupta._6_parallel_options;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.V;

import java.util.Map;

public interface ServingOptions {
    @Agent(outputKey = "servingOptions")
    Map<String, String> suggest(@V("recipe") String recipe);
}