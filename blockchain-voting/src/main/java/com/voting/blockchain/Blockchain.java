package com.voting.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {

    private List<Block> chain = new ArrayList<>();

    public Blockchain() {
        chain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        return new Block("0", "Genesis", "0");
    }

    public void addBlock(String voterId, String candidate) {
        Block previousBlock = chain.get(chain.size() - 1);
        Block newBlock = new Block(voterId, candidate, previousBlock.getHash());
        chain.add(newBlock);
    }

    public List<Block> getChain() {
        return chain;
    }
    
 // Validate entire blockchain
    public boolean isChainValid() {

        for (int i = 1; i < chain.size(); i++) {

            Block current = chain.get(i);
            Block previous = chain.get(i - 1);

            // Recalculate current hash
            if (!current.getHash().equals(current.calculateHash())) {
                return false;
            }

            // Compare stored previous hash
            if (!current.getPreviousHash().equals(previous.getHash())) {
                return false;
            }
        }

        return true;
    }

}

