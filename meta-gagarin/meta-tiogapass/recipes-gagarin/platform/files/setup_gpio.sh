#!/bin/bash

# FM_BMC_READY_N, GPIO S1, active low
gpioset $(gpiofind BMC_READY)=0

# FP_PECI_MUX, active low
gpioset $(gpiofind PECI_MUX_SELECT)=1

exit 0;
