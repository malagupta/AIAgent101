package com.gupta._1_first_request;

import dev.langchain4j.model.chat.ChatModel;


/**
 * I want to use this agent as the backbone
 * for a 101 live master class for creating
 * an AI Agent using Java and LangChain4J.
 * Create a blog post that gets developers
 * excited about learning how to create this
 * Agent, briefly talk about what each about
 * each lab does. Ask users to join a waitlist
 * for this live class which launches soon.
 * I used Java and Langchain4j because it seemed
 * easier and basic to me than using other
 * frameworks such as SpringAI or Embabel.
 */


/**
 * Lab 1:
 *
 * Call a LLM with a request, output the response
 * No constraints.
 *
 * This class demonstrates how to use a chat model to generate a response to a request
 * No AI Agents are created in this example because the task did not need them
 */
public class Demo {

    public static void main(String[] args) {

        // 1. This is a request to be submitted to a chat model
        String request = """
                            I have bread, tomato and cheese. 
                            Suggest one simple dish for one person, ready in 10 minutes.
                            Use only listed ingredients plus water, salt and oil. 
                            Maximum 5 steps. 
                            If nothing sensible is possible, say so. 
                            Don't create fictitious or impossible dishes""";

        // 2. Create a ChatModel
        ChatModel chatModel = ModelConfig.create();

        // 3. Send the request to the chat model and print the response
        System.out.println(chatModel.chat(request));
    }
}
