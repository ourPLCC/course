DVIPSFLAGS = -Ppdf -t landscape
CHAPTER = 3
SLIDES = slides$(CHAPTER)
HANDOUT = hand$(CHAPTER)

all:
	make slides

slides:
	latex $(SLIDES)
	dvips -Ppdf $(DVIPSFLAGS) $(SLIDES)
	ps2pdf $(SLIDES).ps
	psnup -r -2 $(SLIDES).ps $(HANDOUT).ps
	chmod a+r $(SLIDES).ps
	chmod a+r $(SLIDES).pdf
	chmod a+r $(HANDOUT).ps

