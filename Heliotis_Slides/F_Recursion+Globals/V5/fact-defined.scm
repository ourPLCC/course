#lang R5RS

(define fact           (lambda (n)
                           (cond
                               ((zero? n) 1)
                               (#t (* n (fact (- n 1))))
                           )
                       )
)
