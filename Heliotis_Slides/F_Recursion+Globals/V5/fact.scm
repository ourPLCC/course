#lang R5RS

(letrec
    (
        (fact           (lambda (n)
                            (cond
                                ((zero? n) 1)
                                (#t (* n (fact (- n 1))))
                            )
                        )
        )
    )

    (fact 5)
)
