  -----------------------------------------------------------------------------------------------------------------------------------------------------------
    Clock Phase         Router   Router   Operator1   Operator1   Operator2   Operator2   Event List        WorkComplete X WorkComplete Y Notes
          (processed)   Queue             queue                   queue                   (chronological)                                 
  ------- ------------- -------- -------- ----------- ----------- ----------- ----------- ----------------- -------------- -------------- -------------------
       16 A (advance)   empty    idle     empty       X3 (in      empty       Y1 (in      B5 @18, B1 @20,                2              0 At t=16, X2
          -\> B (B4,B3)                               service),               service),   B2 @20, B4 @20                                  finished (B4) and
          -\> C                                       completes               completes                                                   X3 moved from
                                                      at 20 (B4               at 18 (B5                                                   router to operator1
                                                      @20)                    @18)                                                        and started service
                                                                                                                                          (B4 scheduled at
                                                                                                                                          20).

       18 A (advance)   empty    idle     empty       X3 (in      empty       idle (Y1    B1 @20, B2 @20,                2              1 B5 @18 processed
          -\> B (B5)                                  service),               completed   B4 @20                                          -\> Y1 exits the
          \[STOP after                                completes               at t=18)                                                    system. This is the
          this                                        at 20 (B4                                                                           first Y-type client
          B-event\]                                   @20)                                                                                exit; simulation
                                                                                                                                          stops per task.
  -----------------------------------------------------------------------------------------------------------------------------------------------------------
