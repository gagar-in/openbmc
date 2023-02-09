SUMMARY = "OpenBMC for GagarIn - Applications"
PR = "r1"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
        ${PN}-extras \
        ${PN}-fans \
        ${PN}-flash \
        ${PN}-system \
        ${PN}-chassis \
        ${PN}-hostmgmt \
        "
PROVIDES += "virtual/obmc-chassis-mgmt"
PROVIDES += "virtual/obmc-fan-mgmt"
PROVIDES += "virtual/obmc-flash-mgmt"
PROVIDES += "virtual/obmc-system-mgmt"

RPROVIDES:${PN}-chassis += "virtual-obmc-chassis-mgmt"
RPROVIDES:${PN}-fans += "virtual-obmc-fan-mgmt"
RPROVIDES:${PN}-flash += "virtual-obmc-flash-mgmt"
RPROVIDES:${PN}-system += "virtual-obmc-system-mgmt"

SUMMARY:${PN}-chassis = "GagarIn Chassis"
RDEPENDS:${PN}-chassis = " \
        x86-power-control \
        "

SUMMARY:${PN}-fans = "GagarIn Fans"
RDEPENDS:${PN}-fans = " \
        phosphor-pid-control \
        "

SUMMARY:${PN}-flash = "GagarIn Flash"
RDEPENDS:${PN}-flash = " \
        phosphor-software-manager \
        "

RDEPENDS_PN_SYSTEM_EXTRAS = ""
RDEPENDS_PN_SYSTEM_EXTRAS = " \
        gagarin-platform-init \
        phosphor-ipmi-ipmb \
        phosphor-hostlogger \
        phosphor-sel-logger \
        phosphor-logging \
        ipmitool \
        phosphor-ipmi-host \
        phosphor-ipmi-fru \
        phosphor-ipmi-flash \
        phosphor-post-code-manager \
        phosphor-host-postd \
        phosphor-ipmi-kcs \
        phosphor-ipmi-blobs \
        smbios-mdr \
        intel-ipmi-oem \
        tzdata-core \
        "

SUMMARY:${PN}-system = "GagarIn System"
RDEPENDS:${PN}-system = " \
        entity-manager \
        dbus-sensors \
        webui-vue \
        lldpd \
        obmc-console \
        phosphor-pid-control \
        obmc-ikvm \
        phosphor-inventory-manager \
        phosphor-snmp \
        phosphor-software-manager \
        ${RDEPENDS_PN_SYSTEM_EXTRAS} \
        "
