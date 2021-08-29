# Makefile for slides

DVIPSFLAGS = -Ppdf -G0 -t letter -t landscape

SET = unknown
SLIDES = slides-$(SET)
HANDOUT = hand-$(SET)
PAPERSIZE = letter

all:	$(SET)
	@echo "TEXINPUTS=$$TEXINPUTS"
	@TEXINPUTS=$$TEXINPUTS:$(SET) make $(SLIDES).ps

unknown:
	@echo "no directory" ; exit 1

$(SLIDES).ps: $(shell Base/ListTexFiles $(SET)) Base/preamble.tex copyright.tex
	Base/MakeMasterTexFile $(SET)
	latex $(SLIDES)
	dvips $(DVIPSFLAGS) $(SLIDES)
	ps2pdf $(SLIDES).ps
	psnup -2 $(SLIDES).ps $(HANDOUT).ps
	ps2pdf $(HANDOUT).ps
	chmod a+r $(SLIDES).ps $(SLIDES).pdf $(HANDOUT).ps $(HANDOUT).pdf

somewhatclean:
	rm -f *.log *.dvi *.aux

clean: somewhatclean
	rm -f *.tex

veryclean: clean
	rm -f *.ps *.pdf
