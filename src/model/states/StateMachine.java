package model.states;

import java.util.Stack;

public class StateMachine<T extends State> {
	private Stack<T> stateStack;
	
	public StateMachine() {
		stateStack = new Stack<T>();
	}
	
	public void pushState(T state) {
		// pause the current state if it exists
		if(!stateStack.isEmpty())
			currentState().onPause();
		
		// add the new state and enter it
		stateStack.push(state);
		state.onEnter();
	}
	
	public void switchState(T state) {
		// only exit the current state if it exists (allows switching from a null state)
		if(!stateStack.isEmpty())
			currentState().onExit();
		
		// add the new state and enter it
		stateStack.push(state);
		state.onEnter();
	}

	public void popState() {
		// make sure the stack is non-empty
		if(stateStack.isEmpty())
			throw new RuntimeException("Could not pop state from empty StateStack");
		
		// pop the state
		currentState().onExit();
		stateStack.pop();
		
		// if there's still a state left on the stack, we resume
		if(!stateStack.isEmpty())
			currentState().onResume();
	}
	
	// grabs the current state or returns null if the stack is empty
	public T currentState() {
		return stateStack.isEmpty() ? null : stateStack.peek();
	}
}
