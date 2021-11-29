package it.unibo.oop.lab.nesting2;

import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {
	private List<T> list;

	public OneListAcceptable(List<T> list) {
		this.list = list;
	}

	@Override
	public Acceptor<T> acceptor() {
		return new Acceptor<T>() {
			private int count = 0;

			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (!list.contains(newElement)) {
					throw new ElementNotAcceptedException(newElement);
				}
				this.count++;
			}

			@Override
			public void end() throws EndNotAcceptedException {
				if (this.count != list.size()) {
					throw new EndNotAcceptedException();
				}
			}
		};
	}

}
