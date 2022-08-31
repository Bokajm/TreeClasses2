# Klasy drzew

Implementacja abstrakcji drzewa liściastego i iglastego w języku Java.

### Różnice w zachowaniu drzew:
Różnice w rodzajach drzew przejawiają się przede wszystkim w ich cyklu życia - drzewa iglaste wypuszczają liście wraz z gałęziami, podczas gdy liściaste cyklicznie wypuszczają wszystkie naraz oraz zrzucają je. <br>

## Elementy drzewa
Drzewo posiada pień, który wypuszcza gałęzie, z których wyrastają liście oraz kolejne gałęzie.
Na poziomie abstrakcji drzewa, pnie oraz gałęzie przyjmują parametry generyczne pozwalające na "złożenie" drzewa z dowolnych elementów, które zawierają minimalną wymaganą funkcjonalność.

## Liście
- AbstractLeaf - klasa abstrakcyjna, z której dziedziczą klasy właściwych liści, które powinny doprecyzować gatunek oraz zawierać specyficzną dla siebie funkcjonalność. W tym wypadku poszczególne konkretne klasy liści zawierają jedynie nazwę imitującą cechy danego gatunku.

## Elementy drewniane
- AbstractWoodElement - klasa abstrakcyjna uogólniająca gałęzie i pnie jako elementy drewniane, ze względu na część wspólną tych klas - posiadają odwołanie do drzewa, które odpowiada za instancjonowanie nowych elementów, wielkość, oraz możliwość dodawania nowych gałęzi. Klasa przyjmuje rodzaj gałęzi oraz liści, które będą one zawierać.

### Pnie
- Trunk - klasa dziedzicząca po AbstractWoodElement; doprecyzowuje funkcjonalność elementu do zachowania pnia, definiuje metodę wzrostu dla pnia, która odpowiada również za dodawanie nowych gałęzi
- LeafyTrunk - klasa pnia dla drzewa liściastego dziedzicząca po klasie Trunk, zawiera dodatkowo metody pozwalające na inicjowane przez drzewo stworzenie nowych liści oraz zrzucenie obecnych.

### Gałęzie
- AbstractBranch - klasa abstrakcyjna dziedzicząca po AbstractWoodElement; dodaje listę swoich liści oraz funkcjonalność ich dodawania
- AbstractConiferBranch - rozwija klasę abstrakcyjną gałęzi dostosowując ją do sposobu tworzenia nowych liści dla drzew iglastych - są tworzone podczas wzrostu
- AbstractLeafyBranch -  rozwija klasę abstrakcyjną gałęzi dostosowując ją do sposobu tworzenia nowych liści dla drzew liściastych - liście są dodawane oraz zrzucane poprzez wywołanie odpowiedniej metody na gałęzi
- ConiferBranch i LeafyBranch - klasy konkretyzujące powyższe abstrakcje, ze względu na przyjmowanie przez abstrakcje parametrów generycznych gałęzi, umożliwiających dalsze dziedziczenie; klasy ConiferBranch i LeafyBranch przyjmują jedynie klasę tworzonych liści

## Klasy drzew
- AbstractTree - klasa abstrakcyjna będąca generalizacją drzewa; przechowuje typ drzewa, jego wiek i pień, deklaruje motody odpowiadające za wzrost oraz tworzenie nowych elementów drzewa - ze względu na użycie typów generycznych drzewo dostarcza możliwość instancjonowania swoich elementów, które są potem przekazywane do pnia i gałęzi
- AbstractConifer - klasa abstrakcyjna dla drzewa iglastego, ogranicza typy elementów przyjmowanych przez klasy dziedziczące do elementów iglastych
- AbstractLeafyTree -  klasa abstrakcyjna dla drzewa liściastego, ogranicza typy elementów przyjmowanych przez klasy dziedziczące do elementów liściastych, dodaje cykl tworzenia liści oraz metody go umożliwiające
- Oak, Pine oraz Spruce - właściwe klasy drzew, dziedziczą po swoich odpowiednich abstrakcjach, odpowiadają za przykłady konkretnych gatunków dla drzew iglastych i liściastych, definiują jakie klasy elementów będą używane w drzewie oraz umożliwiają ich instancjonowanie