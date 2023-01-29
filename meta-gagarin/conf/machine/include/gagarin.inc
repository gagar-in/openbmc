MACHINEOVERRIDES =. ":gagarin"

require conf/machine/include/gagarin_debug.inc

MACHINE_FEATURES += "\
        obmc-bmc-state-mgmt \
        obmc-phosphor-fan-mgmt \
        obmc-phosphor-flash-mgmt \
        "

VIRTUAL-RUNTIME_skeleton_workbook = "${MACHINE}-config"

PREFERRED_PROVIDER_virtual/obmc-chassis-mgmt = "packagegroup-gagarin-apps"
PREFERRED_PROVIDER_virtual/obmc-fan-mgmt = "packagegroup-gagarin-apps"
PREFERRED_PROVIDER_virtual/obmc-flash-mgmt = "packagegroup-gagarin-apps"
PREFERRED_PROVIDER_virtual/obmc-inventory-data ?= "${VIRTUAL-RUNTIME_skeleton_workbook}"
PREFERRED_PROVIDER_virtual/obmc-system-mgmt = "packagegroup-gagarin-apps"

IMAGE_FEATURES:append = " allow-root-login"

# Most of our hardware uses the default ttyS4 but at 115200.
SERIAL_CONSOLES = "115200;ttyS4"