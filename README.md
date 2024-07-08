Define an AbstractHandler:
  1. Have the Concrete classes like ClientOpenHandler, AccountHandler, etc for each respective steps.
  2. The orchestrator will create a workflow with this.
  3. The controllers can then call the corresponding workflow to perform steps.
