package package3.controller;

import package3.model.vo.Animal;
import package3.model.vo.Cat;
import package3.model.vo.Dog;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] animal = new Animal[5];
		animal[0] = new Dog("호두","치와와",5);
		animal[1] = new Cat("코코","브뤼티쉬숏헤어","집","회색");
		animal[2] = new Dog("마루","치와와",4);
		animal[3] = new Cat("코코","브뤼티쉬숏헤어","마루","회색");
		animal[4] = new Cat("코코","브뤼티쉬숏헤어","거실","흰색");
	
		for(Animal a : animal) {
			a.speak();
		}
	}
}
