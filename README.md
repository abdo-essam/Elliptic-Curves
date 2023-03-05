# Elliptic-Curves

# Faculty Of Computer And Artificial Intelligence Cairo University `FCAI-CU`

## 	Cyber Security Assignment


https://github.com/abdo-essam/Elliptic-Curves/blob/main/elliptic-curve-cryptography-diagram.png?raw=true

This is an implementation of the ElGamal encryption scheme using elliptic curve cryptography. The main method generates a random integer i as the private key for Alice and another random integer d as the private key for Bob. It then calls the 'elgamal' method to perform the encryption and decryption process.

The 'elgamal' method takes in the plaintext data, Alice's private key i, Bob's private key d, the curve parameters a and p, and the coordinates of a point (x1, y1) on the elliptic curve. It first computes the public key for Bob by using the 'Double_and_Add' method to perform point multiplication on (x1, y1) with d. It then computes the shared secret key by using the same method to perform point multiplication on (x1, y1) with i and then on the resulting point with Bob's public key.

Next, it multiplies the plaintext data with the x-coordinate of the shared secret key point modulo p to obtain the ciphertext. It then computes the decryption key by using the 'Double_and_Add' method to perform point multiplication on the shared secret key with Bob's private key d. Finally, it multiplies the ciphertext with the modular inverse of the x-coordinate of the shared secret key point modulo p to obtain the plaintext.

The 'Double_and_Add' method performs point multiplication using the double-and-add algorithm on the input point (x, y) with the elliptic curve parameters a and p, and a positive integer H. It first converts H to binary and then iterates through its bits, doubling the point in each iteration and adding the original point if the bit is 1. It also handles negative slope and negative x-coordinate cases in the addition step.

Note that this implementation uses double precision floating point arithmetic to perform modular inverse and slope calculations, which may not be suitable for cryptographic applications due to potential precision loss and side-channel attacks. Additionally, the curve parameters a and p are hardcoded and not randomly generated, which can also weaken the security of the scheme.


## For More Info : https://avinetworks.com/glossary/elliptic-curve-cryptography/
