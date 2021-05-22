## Parallel vs Asynchronous

Parallel is when processes are done concurrently
and then joined after completion.
The main program waits for all processes to complete, although all processes are concurrent.

Asynchronous is when main program starts without completion of async processes.
Once async processes complete, they can be retrieved using some callback mechanism.
