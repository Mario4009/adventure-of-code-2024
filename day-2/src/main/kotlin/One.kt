package ch.mvoirol

import ch.mvoirol.common.Report
import ch.mvoirol.common.ResourceLoader

fun main() {
    val resources = ResourceLoader()

    val safeReports = mutableListOf<Report>()

    resources.reports.forEach { report ->
        if (report.isValid()) {
            safeReports.add(report)
        }
    }

    println("${safeReports.size} reports are safe!") // 246
}
