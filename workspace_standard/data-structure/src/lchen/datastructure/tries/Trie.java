package lchen.datastructure.tries;

import java.util.HashMap;
import java.util.List;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String key) {
        char[] keyArr = key.toCharArray();

        Node cur = root;
        for (int i = 0; i < keyArr.length; ++i) {
            if (cur.children.containsKey(keyArr[i])) {
                cur = cur.children.get(keyArr[i]);
            } else {
                Node newNode = new Node();
                cur.children.put(keyArr[i], newNode);
                cur = newNode;
            }

            if (i == keyArr.length - 1) {
                cur.isEndOfWord = true;
            }
        }
    }

    public boolean search(String key) {
        char[] keyArr = key.toCharArray();

        Node cur = root;
        for (int i = 0; i < keyArr.length; ++i) {
            if (cur.children.containsKey(keyArr[i])) {
                cur = cur.children.get(keyArr[i]);
            } else {
                return false;
            }
        }

        return cur.isEndOfWord;
    }

    public List<String> searchWords(String prefix) {
        return null;
    }

    public void delete(String key) {
        char[] keyArr = key.toCharArray();
        delete(root, keyArr, 0);
    }

    // Return true if the current key in the depth position can be deleted from the
    // parent
    private static boolean delete(Node parent, char[] keyArr, int depth) {
        if (depth == keyArr.length - 1) {
            // it's the last character in the word
            if (parent.children.containsKey(keyArr[depth])) {
                Node child = parent.children.get(keyArr[depth]);
                child.isEndOfWord = false;

                // check if the child can be deleted
                if (child.isEmpty()) {
                    return true;
                }
            }

            return false;
        }

        if (parent.children.containsKey(keyArr[depth])) {
            // check if the child can be deleted
            Node child = parent.children.get(keyArr[depth]);
            boolean toDelete = delete(child, keyArr, depth + 1);
            if (toDelete) {
                parent.children.remove(keyArr[depth]);
            }

            if (!parent.isEndOfWord && parent.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return root.children.size() == 0;
    }

    public int size() {
        return numberOfWords(root);
    }

    public int numberOfWords(String prefix) {
        return 0;
    }

    private int numberOfWords(Node node) {
        return 0;
    }

    public static class Node {
        HashMap<Character, Node> children;
        boolean isEndOfWord;

        public Node() {
            children = new HashMap<Character, Node>();
            isEndOfWord = false;
        }

        // if it's not prefix of any other words
        boolean isEmpty() {
            return children.size() == 0;
        }
    }

    public static void main(String[] args) {
        // Input dictionary (use only 'a' through 'z' and lower case)
        String[] dict = { "the", "a", "there", "c", "answer", "any", "by", "car", "bye", "their", "cartel" };

        String[] keys = { "the", "a", "there", "c", "answer", "any", "by", "car", "bye", "their", "cartel", "java",
                "implementation", "of", "search", "and", "insert", "operations" };

        Trie trie = new Trie();
        System.out.println("********** The trie is empty: " + trie.isEmpty());

        for (int i = 0; i < dict.length; ++i) {
            trie.insert(dict[i]);
        }
        System.out.println();
        System.out.println("********** After insertions, the trie is empty: " + trie.isEmpty());

        System.out.println();
        for (int i = 0; i < keys.length; ++i) {
            System.out.println("Search for " + keys[i] + ": " + trie.search(keys[i]));
        }

        trie.insert("java");
        System.out.println();
        System.out.println("********** After adding 'java'");
        for (int i = 0; i < keys.length; ++i) {
            System.out.println("Search for " + keys[i] + ": " + trie.search(keys[i]));
        }

        trie.delete("cartel");
        System.out.println();
        System.out.println("********** After deleting 'cartel'");
        for (int i = 0; i < keys.length; ++i) {
            System.out.println("Search for " + keys[i] + ": " + trie.search(keys[i]));
        }

        trie.delete("c");
        System.out.println();
        System.out.println("********** After deleting 'c'");
        for (int i = 0; i < keys.length; ++i) {
            System.out.println("Search for " + keys[i] + ": " + trie.search(keys[i]));
        }

        trie.insert("c");
        System.out.println();
        System.out.println("********** After adding 'c'");
        for (int i = 0; i < keys.length; ++i) {
            System.out.println("Search for " + keys[i] + ": " + trie.search(keys[i]));
        }

        trie.insert("cartel");
        System.out.println();
        System.out.println("********** After adding 'cartel'");
        for (int i = 0; i < keys.length; ++i) {
            System.out.println("Search for " + keys[i] + ": " + trie.search(keys[i]));
        }

        for (int i = 0; i < dict.length; ++i) {
            trie.delete(dict[i]);
        }
        System.out.println();
        System.out.println("********** After deleting initial dictionary, the trie is empty: " + trie.isEmpty());

        trie.delete("java");
        System.out.println();
        System.out.println("********** After deleting 'java', the trie is empty: " + trie.isEmpty());

        System.out.println();
        for (int i = 0; i < keys.length; ++i) {
            System.out.println("Search for " + keys[i] + ": " + trie.search(keys[i]));
        }

        System.out.println("********** ********** **********");
        System.out.println("Re-adding a new dictionary");

        // A dictionary from
        // https://nasa.tumblr.com/post/177980135484/what-can-we-learn-from-the-universes-baby
        String[] dict2 = { "what", "can", "we", "learn", "from", "the", "universe", "baby", "picture", "if", "you",
                "look", "at", "your", "baby", "photos", "you", "might", "see", "hints", "of", "the", "person", "you",
                "are", "today", "a", "certain", "look", "in", "the", "eyes", "maybe", "the", "hint", "of", "your",
                "future", "nose", "or", "ears", "in", "the", "same", "way", "scientists", "examine", "the", "universe",
                "baby", "picture", "for", "clues", "about", "how", "it", "grew", "into", "the", "cosmos", "we", "know",
                "now", "this", "baby", "photo", "is", "the", "cosmic", "microwave", "background", "a", "faint", "glow",
                "that", "permeates", "the", "universe", "in", "all", "directions", "in", "late", "september", "nasa",
                "plans", "to", "launch", "a", "balloon", "based", "astronomical", "observatory", "from", "fort",
                "sumner", "new", "mexico", "to", "study", "the", "universe", "baby", "picture", "meet", "piper!", "the",
                "primordial", "inflation", "polarization", "explorer", "will", "fly", "at", "the", "edge", "of", "our",
                "atmosphere", "to", "look", "for", "subtle", "patterns", "in", "the", "the", "is", "cold", "really",
                "really", "cold", "the", "average", "temperature", "is", "around", "minus", "degrees", "fahrenheit",
                "it", "formed", "years", "after", "the", "big", "bang", "which", "scientists", "think", "happened",
                "about", "billion", "years", "ago", "when", "it", "was", "first", "discovered", "the", "temperature",
                "looked", "very", "uniform", "but", "researchers", "later", "found", "there", "are", "slight",
                "variations", "like", "hot", "and", "cold", "spots", "the", "is", "the", "oldest", "light", "in", "the",
                "universe", "that", "we", "can", "see", "anything", "before", "the", "is", "foggy", "literally",
                "before", "the", "the", "universe", "was", "a", "fog", "of", "hot", "dense", "plasma", "by", "hot",
                "we", "talking", "about", "million", "degrees", "f", "that", "so", "hot", "that", "atoms", "could",
                "exist", "yet", "there", "was", "just", "a", "soup", "of", "electrons", "and", "protons", "electrons",
                "are", "great", "at", "deflecting", "light", "so", "any", "light", "that", "existed", "in", "the",
                "first", "few", "hundred", "thousand", "years", "after", "the", "big", "bang", "could", "travel",
                "very", "far", "before", "bouncing", "off", "electrons", "similar", "to", "the", "way", "a", "car",
                "headlights", "get", "diffused", "in", "fog", "after", "the", "big", "bang", "the", "universe",
                "started", "expanding", "rapidly", "in", "all", "directions", "this", "expansion", "is", "still",
                "happening", "today", "as", "the", "universe", "continued", "to", "expand", "it", "cooled", "by", "the",
                "time", "the", "universe", "reached", "its", "birthday", "it", "had", "cooled", "enough", "that",
                "electrons", "and", "protons", "could", "combine", "into", "hydrogen", "atoms", "for", "the", "first",
                "time", "scientists", "call", "this", "era", "recombination", "hydrogen", "atoms", "don’t", "deflect",
                "light", "nearly", "as", "well", "as", "loose", "electrons", "and", "the", "fog", "lifted", "light",
                "could", "now", "travel", "long", "distances", "across", "the", "universe", "the", "light", "we", "see",
                "in", "the", "comes", "from", "the", "recombination", "era", "as", "it", "traveled", "across", "the",
                "universe", "through", "the", "formation", "of", "stars", "and", "galaxies", "it", "lost", "energy",
                "now", "we", "observe", "it", "in", "the", "microwave", "part", "of", "the", "electromagnetic",
                "spectrum", "which", "is", "less", "energetic", "than", "visible", "light", "and", "therefore",
                "invisible", "to", "our", "eyes", "the", "first", "baby", "photo", "of", "the", "really", "a", "map",
                "of", "the", "sky", "in", "microwaves", "came", "from", "our", "cosmic", "background", "explorer",
                "which", "operated", "from", "to", "why", "are", "we", "so", "interested", "in", "the", "universe",
                "baby", "picture", "well", "it", "helped", "us", "learn", "a", "lot", "about", "the", "structure", "of",
                "the", "universe", "around", "us", "today", "for", "example", "the", "wilkinson", "microwave",
                "anisotropy", "probe", "produced", "a", "detailed", "map", "of", "the", "and", "helped", "us", "learn",
                "that", "the", "universe", "is", "percent", "dark", "energy", "percent", "dark", "matter", "and",
                "just", "percent", "normal", "matter", "the", "stuff", "that", "you", "and", "stars", "are", "made",
                "of", "right", "after", "the", "big", "bang", "we", "pretty", "sure", "the", "universe", "was", "tiny",
                "really", "tiny", "everything", "we", "see", "today", "would", "have", "been", "stuffed", "into",
                "something", "smaller", "than", "a", "proton", "if", "the", "universe", "started", "out", "that",
                "small", "then", "it", "would", "have", "followed", "the", "rules", "of", "quantum", "mechanics",
                "quantum", "mechanics", "allows", "all", "sorts", "of", "strange", "things", "to", "happen", "matter",
                "and", "energy", "can", "be", "borrowed", "from", "the", "future", "then", "crash", "back", "into",
                "nothingness", "and", "then", "cosmic", "inflation", "happened", "and", "the", "universe", "suddenly",
                "expanded", "by", "a", "trillion", "trillion", "times", "all", "this", "chaos", "creates", "a", "sea",
                "of", "gravitational", "waves", "these", "are", "called", "primordial", "gravitational", "waves", "and",
                "come", "from", "a", "different", "source", "than", "the", "gravitational", "waves", "you", "may",
                "have", "heard", "about", "from", "merging", "neutron", "stars", "and", "black", "holes", "the",
                "signal", "of", "the", "primordial", "gravitational", "waves", "is", "a", "bit", "like", "white",
                "noise", "where", "the", "signal", "from", "merging", "dead", "stars", "is", "like", "a", "whistle",
                "you", "can", "pick", "up", "over", "the", "noise", "these", "gravitational", "waves", "filled", "the",
                "baby", "universe", "and", "created", "distinct", "patterns", "called", "b", "mode", "polarization",
                "in", "the", "light", "these", "patterns", "have", "handedness", "which", "means", "even", "though",
                "they", "mirror", "images", "of", "each", "other", "they", "not", "symmetrical", "like", "trying", "to",
                "wear", "a", "left", "hand", "glove", "on", "your", "right", "hand", "they", "distinct", "from",
                "another", "kind", "of", "polarization", "called", "e", "mode", "which", "is", "symmetrical", "and",
                "echoes", "the", "distribution", "of", "matter", "in", "the", "universe", "that", "where", "piper",
                "comes", "in", "piper", "two", "telescopes", "sit", "in", "a", "hot", "tub", "sized", "container", "of",
                "liquid", "helium", "which", "runs", "about", "minus", "degrees", "f", "it’ll", "look", "at", "percent",
                "of", "the", "sky", "and", "is", "extremely", "sensitive", "so", "it", "will", "help", "us", "learn",
                "even", "more", "about", "the", "early", "days", "of", "the", "universe", "by", "telling", "us", "more",
                "about", "polarization", "and", "those", "primordial", "gravitational", "waves", "piper", "will",
                "help", "us", "understand", "how", "the", "early", "universe", "grew", "from", "that", "first", "baby",
                "picture", "piper", "first", "launch", "window", "in", "fort", "sumner", "new", "mexico", "is", "in",
                "late", "september", "when", "it", "getting", "ready", "to", "launch", "you’ll", "be", "able", "to",
                "watch", "the", "balloon", "being", "filled", "on", "the", "columbia", "scientific", "balloon",
                "facility", "website", "follow", "nasa", "blueshift", "on", "twitter", "or", "facebook", "for",
                "updates", "about", "piper", "and", "when", "the", "livestream", "will", "be", "available" };
        for (int i = 0; i < dict2.length; ++i) {
            trie.insert(dict2[i]);
        }
        System.out.println("Total added: " + dict2.length);
        System.out.println("Total words: " + trie.size());

        System.out.println();
        for (int i = 0; i < keys.length; ++i) {
            System.out.println("Search for " + keys[i] + ": " + trie.search(keys[i]));
        }
    }
}
