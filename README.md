# Implementare

## Structura
Am modificat structura de la etapa anterioara:
* Am adaugat HashMap-uri in clasele User, Artist si Host pentru a retine informatii pentru wrapped.
* Am adaugat clasele WrappedStatsArtist si WrappedStatsUser pentru a pune informatiile necesare pentru wrapped din User si Artist, pentru formatarea output-ului.
* Am adaugat design patternul visitor pentru a vizita fisierele audio pentru a vedea ce tip sunt cand incrementez statisticile pt wrapped in clasa Player

## Interactiuni
* Clasele WrappedStatsArtist si WrappedStatsUser interactioneaza cu field-urile din User si Artist pentru a pune informatiile necesare pentru wrapped pentru output.
