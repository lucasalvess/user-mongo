#!/bin/bash

exec java -XX:+UnlockExperimentalVMOptions \
	      -XX:+UseZGC \
	      -XX:+TieredCompilation \
          -XX:TieredStopAtLevel=1 \
          $*
