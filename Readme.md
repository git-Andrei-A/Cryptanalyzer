# Study project "Cryptanalyzer";

Authtor Andrei Arsenev (andrei@arsenev.pro);

Java SDK 21 (Microsoft Open JDK);

## Released: Encryption/Decryption/Bruteforce DecryptioniIn two modes:

### MODE ConsoleRunner

All files must be in folder "texts" and will be genereted in this folder.

Examples for run:

    cryptoanalizer.ConsoleRunner encode text.txt encoded.txt 50

text.txt - file with text for encode;
     
encoded.txt - file with result of encode;

50 - encode key;     
     
    cryptoanalizer.ConsoleRunner decode encoded.txt decrypted.txt 50

encoded.txt - file with text encoded text;
     
decrypted.txt - file with decrypted text;

50 - decrypt key;

    cryptoanalizer.ConsoleRunner bruteforce reference.txt encoded.txt brutForceDecrypted.txt
    
reference.txt - file with reference text (example of languages);

encoded.txt - file with text encoded text;

brutForceDecrypted.txt - - file with decrypted text;

### MODE TextMenuRunner

run cryptoanalizer.TextMenuRunner 

And use app dialog:

1. Encode
   
3. Decode
   
5. BrutForce
   
7. Exit



	