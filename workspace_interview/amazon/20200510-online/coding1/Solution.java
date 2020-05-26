/**
 * Your team at Amazon owns a website and wants to raise the bar on customer experience. You are tasked with figuring out which parts of the websites are the most confusing to customers. You need to write an algorithm that analyzes many questions typed into Help Search box and finds the most frequently used words, excluding common words like "the" or "an".
 *
 * Write an algorithm to find the most frequently used word in the help search box, excluding the commonly used words. In the context of this search, a word is an alphabetic sequence of characters having no whitespace or punctuation.
 *
 * Input:
 * The input to the fuction/method consists of two arguments
 * helpText, a string representing many help searches.
 * wordsToExclude, a list of strings representing the commonly used words to be excluded while analyzing the word frequency.
 *
 * Output:
 * Return a list of strings representing the most frequently used words in the help search. In the case of a tie, return all of the most frequently used words.
 *
 * Note:
 * The words in the search query which differ only by the case are counted as the same word.
 * The order of words does not matter in the output list.
 * All words in the wordToExclude list are unique.
 * Punctuation should be treated as white space.
 * Numbers and special characters should be treated as punctuation.
 *
 * Example:
 * Input:
 * helpText = "Purchase Order Item Help can't find item item is too much part of purchase need fix for image item delivered too fast purchase order too big is purchase order coming? Too big why?"
 * wordsToExclude = ["help","fix","too","is","of"]
 *
 * Output:
 * ["item","purchase"] or ["purchase", "item"]
 *
 * Explanation:
 * The word "too' has a maximum of 4 frequency but this word should be excluded while analyzing the word frequency. The words "purchase" and "item" both have a maximum frequency of 4 and is not predetermined to be excluded from your analysis.
 * So the output is ["item", "purchase"] or ["purchase", "item"]. the order of words does no matter.
 **/

public class Solution {
	List<String> retrieveMostFrequentlyUsedWords(String helpText, List<String> wordsToExclude) {
	}
}
