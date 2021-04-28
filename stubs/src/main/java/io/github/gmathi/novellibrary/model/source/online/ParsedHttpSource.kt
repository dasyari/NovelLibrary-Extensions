package io.github.gmathi.novellibrary.model.source.online

import io.github.gmathi.novellibrary.model.database.Novel
import io.github.gmathi.novellibrary.model.database.WebPage
import io.github.gmathi.novellibrary.model.other.NovelsPage
import okhttp3.Response
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

/**
 * A simple implementation for sources from a website using Jsoup, an HTML parser.
 */
@Suppress("unused", "unused_parameter")
abstract class ParsedHttpSource : HttpSource() {

    /**
     * Parses the response from the site and returns a [NovelsPage] object.
     *
     * @param response the response from the site.
     */
    override fun popularNovelsParse(response: Response): NovelsPage {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each novel.
     */
    protected abstract fun popularNovelsSelector(): String

    /**
     * Returns a novel from the given [element]. Most sites only show the title and the url, it's
     * totally fine to fill only those two values.
     *
     * @param element an element obtained from [popularNovelsSelector].
     */
    protected abstract fun popularNovelsFromElement(element: Element): Novel

    /**
     * Returns the Jsoup selector that returns the <a> tag linking to the next page, or null if
     * there's no next page.
     */
    protected abstract fun popularNovelNextPageSelector(): String?


    /**
     * Parses the response from the site and returns a [NovelsPage] object.
     *
     * @param response the response from the site.
     */
    override fun searchNovelsParse(response: Response): NovelsPage {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each novel.
     */
    protected abstract fun searchNovelsSelector(): String

    /**
     * Returns a novel from the given [element]. Most sites only show the title and the url, it's
     * totally fine to fill only those two values.
     *
     * @param element an element obtained from [searchNovelsSelector].
     */
    protected abstract fun searchNovelsFromElement(element: Element): Novel

    /**
     * Returns the Jsoup selector that returns the <a> tag linking to the next page, or null if
     * there's no next page.
     */
    protected abstract fun searchNovelsNextPageSelector(): String?


    /**
     * Parses the response from the site and returns a [NovelsPage] object.
     *
     * @param response the response from the site.
     */
    override fun latestUpdatesParse(response: Response): NovelsPage {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each novel.
     */
    protected abstract fun latestUpdatesSelector(): String

    /**
     * Returns a novel from the given [element]. Most sites only show the title and the url, it's
     * totally fine to fill only those two values.
     *
     * @param element an element obtained from [latestUpdatesSelector].
     */
    protected abstract fun latestUpdatesFromElement(element: Element): Novel

    /**
     * Returns the Jsoup selector that returns the <a> tag linking to the next page, or null if
     * there's no next page.
     */
    protected abstract fun latestUpdatesNextPageSelector(): String?


    /**
     * Parses the response from the site and returns the details of a novel.
     *
     * @param response the response from the site.
     */
    override fun novelDetailsParse(novel: Novel, response: Response): Novel {
        throw Exception("Stub!")
    }

    /**
     * Returns the details of the novel from the given [document].
     *
     * @param document the parsed document.
     */
    protected abstract fun novelDetailsParse(novel: Novel, document: Document): Novel


    /**
     * Parses the response from the site and returns a list of chapters.
     *
     * @param response the response from the site.
     */
    override fun chapterListParse(novel: Novel, response: Response): List<WebPage> {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each chapter.
     */
    protected abstract fun chapterListSelector(): String

    /**
     * Returns a chapter from the given element.
     *
     * @param element an element obtained from [chapterListSelector].
     */
    protected abstract fun chapterFromElement(element: Element): WebPage
}

