package br.com.erudio.vo.request

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the request body for creating a chat completion.
 * Contains information such as the model to use, the messages to generate chat completions for,
 * sampling temperature, top-p value, number of completion choices to generate, stream configuration,
 * stop sequences, maximum number of tokens, presence and frequency penalties, logit bias, and user identifier.
 */
data class ChatGptRequest(
    /**
     * ID of the model to use. Currently, only gpt-3.5-turbo and gpt-3.5-turbo-0301 are supported.
     */
    val model: String,
    /**
     * The messages to generate chat completions for, in the chat format.
     */
    val messages: ArrayList<Message>,
    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random,
     * while lower values like 0.2 will make it more focused and deterministic.
     *
     * We generally recommend altering this or top_p but not both.
     */
    /** val temperature: Double = 1.0,
    /**
     * An alternative to sampling with temperature, called nucleus sampling,
     * where the model considers the results of the tokens with top_p probability mass.
     * So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     *
     * We generally recommend altering this or temperature but not both.
     */
    @field:JsonProperty("top_p")
    val topP: Double = 1.0,
    /**
     * How many chat completion choices to generate for each input message.
     */
    val n: Int = 1,
    /**
     * If set, partial message deltas will be sent, like in ChatGPT.
     * Tokens will be sent as data-only server-sent events as they become available,
     * with the stream terminated by a data: DONE message.
     */
    val stream: Boolean = false,
    /**
     * Up to 4 sequences where the API will stop generating further tokens.
     */
    val stop: List<String>? = null,
    /**
     * The maximum number of tokens allowed for the generated answer.
     * By default, the number of tokens the model can return will be (4096 - prompt tokens).
     */
    @field:JsonProperty("max_tokens")
    val maxTokens: Int? = null,
    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they appear in the text so far,
     * increasing the model's likelihood to talk about new topics.
     */
    @field:JsonProperty("presence_penalty")
    val presencePenalty: Double = 0.0,
    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing frequency in the text so far,
     * decreasing the model's likelihood to repeat the same line verbatim.
     */
    @field:JsonProperty("frequency_penalty")
    val frequencyPenalty: Double = 0.0,
    /**
     * Modify the likelihood of specified tokens appearing in the completion.
     * Accepts a json object that maps tokens (specified by their token ID in the tokenizer)
     * to an associated bias value from -100 to 100.
     * Mathematically, the bias is added to the logits generated by the model prior to sampling.
     * The exact effect will vary per model, but values between -1 and 1 should decrease or increase likelihood of selection;
     * values like -100 or 100 should result in a ban or exclusive selection of the relevant token.
     */
    @field:JsonProperty("logit_bias")
    val logitBias: Map<String, Double>? = null,
    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     */
    val user: String? = null,
    */
)