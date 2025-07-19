package cryptoanalizer.commands;

import cryptoanalizer.entity.Result;

public interface Action {

    Result execute (String[] parameters);

}