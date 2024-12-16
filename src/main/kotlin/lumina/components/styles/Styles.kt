package lumina.components.styles

import lumina.components.ui.component.Component

@Suppress("unused")
class Styles(private val component: Component) {
    var zIndex: Int
        get() = component.getStyle("z-index").toInt()
        set(value) = component.setStyle("z-index", "$value")

    var backgroundOpacity: Double
        get() {
            val currentBg = component.getStyle("background-color")
            if (currentBg.startsWith("#")) {
                return currentBg.substring(7).toDouble() / 100
            } else if (currentBg.startsWith("rgba")) {
                val split = currentBg.split(",")
                return split[3].substring(0, split[3].length - 1).toDouble() / 100
            }
            return 0.0
        }
        set(value) {
            var currentBg = component.getStyle("background-color")
            if (currentBg.startsWith("#")) {
                if (currentBg.length == 7) {
                    currentBg += "${(value * 100).toInt()}"
                } else {
                    currentBg = currentBg.substring(0, 7)
                    currentBg += "${(value * 100).toInt()}"
                }
            } else if (currentBg.startsWith("rgba")) {
                val split = currentBg.split(",")
                currentBg = "rgba(${split[0]},${split[1]},${split[2]},${value})"
            } else {
                currentBg = "#000000${(value * 100).toInt()}"
            }
            println(currentBg)
            component.setStyle("background-color", currentBg)
        }

    var borderRadius: String
        get() = component.getStyle("border-radius")
        set(value) = component.setStyle("border-radius", value)

    var backgroundColor: String
        get() = component.getStyle("background-color")
        set(value) = component.setStyle("background-color", value)

    var color: String
        get() = component.getStyle("color")
        set(value) = component.setStyle("color", value)

    var display: String
        get() = component.getStyle("display")
        set(value) = component.setStyle("display", value)

    var webkitLineClamp: String
        get() = component.getStyle("-webkit-line-clamp")
        set(value) = component.setStyle("-webkit-line-clamp", value)

    var accentColor: String
        get() = component.getStyle("accent-color")
        set(value) = component.setStyle("accent-color", value)

    var alignContent: String
        get() = component.getStyle("align-content")
        set(value) = component.setStyle("align-content", value)

    var alignItems: String
        get() = component.getStyle("align-items")
        set(value) = component.setStyle("align-items", value)

    var alignSelf: String
        get() = component.getStyle("align-self")
        set(value) = component.setStyle("align-self", value)

    var alignmentBaseline: String
        get() = component.getStyle("alignment-baseline")
        set(value) = component.setStyle("alignment-baseline", value)

    var anchorName: String
        get() = component.getStyle("anchor-name")
        set(value) = component.setStyle("anchor-name", value)

    var anchorScope: String
        get() = component.getStyle("anchor-scope")
        set(value) = component.setStyle("anchor-scope", value)

    var animation: String
        get() = component.getStyle("animation")
        set(value) = component.setStyle("animation", value)

    var animationComposition: String
        get() = component.getStyle("animation-composition")
        set(value) = component.setStyle("animation-composition", value)

    var animationDelay: String
        get() = component.getStyle("animation-delay")
        set(value) = component.setStyle("animation-delay", value)

    var animationDirection: String
        get() = component.getStyle("animation-direction")
        set(value) = component.setStyle("animation-direction", value)

    var animationDuration: String
        get() = component.getStyle("animation-duration")
        set(value) = component.setStyle("animation-duration", value)

    var animationFillMode: String
        get() = component.getStyle("animation-fill-mode")
        set(value) = component.setStyle("animation-fill-mode", value)

    var animationIterationCount: String
        get() = component.getStyle("animation-iteration-count")
        set(value) = component.setStyle("animation-iteration-count", value)

    var animationName: String
        get() = component.getStyle("animation-name")
        set(value) = component.setStyle("animation-name", value)

    var animationPlayState: String
        get() = component.getStyle("animation-play-state")
        set(value) = component.setStyle("animation-play-state", value)

    var animationRange: String
        get() = component.getStyle("animation-range")
        set(value) = component.setStyle("animation-range", value)

    var animationRangeEnd: String
        get() = component.getStyle("animation-range-end")
        set(value) = component.setStyle("animation-range-end", value)

    var animationRangeStart: String
        get() = component.getStyle("animation-range-start")
        set(value) = component.setStyle("animation-range-start", value)

    var animationTimeline: String
        get() = component.getStyle("animation-timeline")
        set(value) = component.setStyle("animation-timeline", value)

    var animationTimingFunction: String
        get() = component.getStyle("animation-timing-function")
        set(value) = component.setStyle("animation-timing-function", value)

    var appearance: String
        get() = component.getStyle("appearance")
        set(value) = component.setStyle("appearance", value)

    var aspectRatio: String
        get() = component.getStyle("aspect-ratio")
        set(value) = component.setStyle("aspect-ratio", value)

    var backfaceVisibility: String
        get() = component.getStyle("backface-visibility")
        set(value) = component.setStyle("backface-visibility", value)

    var baselineShift: String
        get() = component.getStyle("baseline-shift")
        set(value) = component.setStyle("baseline-shift", value)

    var baselineSource: String
        get() = component.getStyle("baseline-source")
        set(value) = component.setStyle("baseline-source", value)

    var blockEllipsis: String
        get() = component.getStyle("block-ellipsis")
        set(value) = component.setStyle("block-ellipsis", value)

    var blockSize: String
        get() = component.getStyle("block-size")
        set(value) = component.setStyle("block-size", value)

    var bookmarkLabel: String
        get() = component.getStyle("bookmark-label")
        set(value) = component.setStyle("bookmark-label", value)

    var bookmarkLevel: String
        get() = component.getStyle("bookmark-level")
        set(value) = component.setStyle("bookmark-level", value)

    var bookmarkState: String
        get() = component.getStyle("bookmark-state")
        set(value) = component.setStyle("bookmark-state", value)

    var borderBlock: String
        get() = component.getStyle("border-block")
        set(value) = component.setStyle("border-block", value)

    var borderBlockColor: String
        get() = component.getStyle("border-block-color")
        set(value) = component.setStyle("border-block-color", value)

    var borderBlockEnd: String
        get() = component.getStyle("border-block-end")
        set(value) = component.setStyle("border-block-end", value)

    var borderBlockEndColor: String
        get() = component.getStyle("border-block-end-color")
        set(value) = component.setStyle("border-block-end-color", value)

    var borderBlockEndStyle: String
        get() = component.getStyle("border-block-end-style")
        set(value) = component.setStyle("border-block-end-style", value)

    var borderBlockEndWidth: String
        get() = component.getStyle("border-block-end-width")
        set(value) = component.setStyle("border-block-end-width", value)

    var borderBlockStart: String
        get() = component.getStyle("border-block-start")
        set(value) = component.setStyle("border-block-start", value)

    var borderBlockStartColor: String
        get() = component.getStyle("border-block-start-color")
        set(value) = component.setStyle("border-block-start-color", value)

    var borderBlockStartStyle: String
        get() = component.getStyle("border-block-start-style")
        set(value) = component.setStyle("border-block-start-style", value)

    var borderBlockStartWidth: String
        get() = component.getStyle("border-block-start-width")
        set(value) = component.setStyle("border-block-start-width", value)

    var borderBlockStyle: String
        get() = component.getStyle("border-block-style")
        set(value) = component.setStyle("border-block-style", value)

    var borderBlockWidth: String
        get() = component.getStyle("border-block-width")
        set(value) = component.setStyle("border-block-width", value)

    var borderBoundary: String
        get() = component.getStyle("border-boundary")
        set(value) = component.setStyle("border-boundary", value)

    var borderCollapse: String
        get() = component.getStyle("border-collapse")
        set(value) = component.setStyle("border-collapse", value)

    var borderEndEndRadius: String
        get() = component.getStyle("border-end-end-radius")
        set(value) = component.setStyle("border-end-end-radius", value)

    var borderEndStartRadius: String
        get() = component.getStyle("border-end-start-radius")
        set(value) = component.setStyle("border-end-start-radius", value)

    var borderInline: String
        get() = component.getStyle("border-inline")
        set(value) = component.setStyle("border-inline", value)

    var borderInlineColor: String
        get() = component.getStyle("border-inline-color")
        set(value) = component.setStyle("border-inline-color", value)

    var borderInlineEnd: String
        get() = component.getStyle("border-inline-end")
        set(value) = component.setStyle("border-inline-end", value)

    var borderInlineEndColor: String
        get() = component.getStyle("border-inline-end-color")
        set(value) = component.setStyle("border-inline-end-color", value)

    var borderInlineEndStyle: String
        get() = component.getStyle("border-inline-end-style")
        set(value) = component.setStyle("border-inline-end-style", value)

    var borderInlineEndWidth: String
        get() = component.getStyle("border-inline-end-width")
        set(value) = component.setStyle("border-inline-end-width", value)

    var borderInlineStart: String
        get() = component.getStyle("border-inline-start")
        set(value) = component.setStyle("border-inline-start", value)

    var borderInlineStartColor: String
        get() = component.getStyle("border-inline-start-color")
        set(value) = component.setStyle("border-inline-start-color", value)

    var borderInlineStartStyle: String
        get() = component.getStyle("border-inline-start-style")
        set(value) = component.setStyle("border-inline-start-style", value)

    var borderInlineStartWidth: String
        get() = component.getStyle("border-inline-start-width")
        set(value) = component.setStyle("border-inline-start-width", value)

    var borderInlineStyle: String
        get() = component.getStyle("border-inline-style")
        set(value) = component.setStyle("border-inline-style", value)

    var borderInlineWidth: String
        get() = component.getStyle("border-inline-width")
        set(value) = component.setStyle("border-inline-width", value)

    var borderSpacing: String
        get() = component.getStyle("border-spacing")
        set(value) = component.setStyle("border-spacing", value)

    var borderStartEndRadius: String
        get() = component.getStyle("border-start-end-radius")
        set(value) = component.setStyle("border-start-end-radius", value)

    var borderStartStartRadius: String
        get() = component.getStyle("border-start-start-radius")
        set(value) = component.setStyle("border-start-start-radius", value)

    var bottom: String
        get() = component.getStyle("bottom")
        set(value) = component.setStyle("bottom", value)

    var boxSizing: String
        get() = component.getStyle("box-sizing")
        set(value) = component.setStyle("box-sizing", value)

    var boxSnap: String
        get() = component.getStyle("box-snap")
        set(value) = component.setStyle("box-snap", value)

    var breakAfter: String
        get() = component.getStyle("break-after")
        set(value) = component.setStyle("break-after", value)

    var breakBefore: String
        get() = component.getStyle("break-before")
        set(value) = component.setStyle("break-before", value)

    var breakInside: String
        get() = component.getStyle("break-inside")
        set(value) = component.setStyle("break-inside", value)

    var captionSide: String
        get() = component.getStyle("caption-side")
        set(value) = component.setStyle("caption-side", value)

    var caret: String
        get() = component.getStyle("caret")
        set(value) = component.setStyle("caret", value)

    var caretColor: String
        get() = component.getStyle("caret-color")
        set(value) = component.setStyle("caret-color", value)

    var caretShape: String
        get() = component.getStyle("caret-shape")
        set(value) = component.setStyle("caret-shape", value)

    var colorInterpolationFilters: String
        get() = component.getStyle("color-interpolation-filters")
        set(value) = component.setStyle("color-interpolation-filters", value)

    var columnGap: String
        get() = component.getStyle("column-gap")
        set(value) = component.setStyle("column-gap", value)

    var contain: String
        get() = component.getStyle("contain")
        set(value) = component.setStyle("contain", value)

    var containIntrinsicBlockSize: String
        get() = component.getStyle("contain-intrinsic-block-size")
        set(value) = component.setStyle("contain-intrinsic-block-size", value)

    var containIntrinsicHeight: String
        get() = component.getStyle("contain-intrinsic-height")
        set(value) = component.setStyle("contain-intrinsic-height", value)

    var containIntrinsicInlineSize: String
        get() = component.getStyle("contain-intrinsic-inline-size")
        set(value) = component.setStyle("contain-intrinsic-inline-size", value)

    var containIntrinsicSize: String
        get() = component.getStyle("contain-intrinsic-size")
        set(value) = component.setStyle("contain-intrinsic-size", value)

    var containIntrinsicWidth: String
        get() = component.getStyle("contain-intrinsic-width")
        set(value) = component.setStyle("contain-intrinsic-width", value)

    var container: String
        get() = component.getStyle("container")
        set(value) = component.setStyle("container", value)

    var containerName: String
        get() = component.getStyle("container-name")
        set(value) = component.setStyle("container-name", value)

    var containerType: String
        get() = component.getStyle("container-type")
        set(value) = component.setStyle("container-type", value)

    var content: String
        get() = component.getStyle("content")
        set(value) = component.setStyle("content", value)

    var contentVisibility: String
        get() = component.getStyle("content-visibility")
        set(value) = component.setStyle("content-visibility", value)

    var counterIncrement: String
        get() = component.getStyle("counter-increment")
        set(value) = component.setStyle("counter-increment", value)

    var counterReset: String
        get() = component.getStyle("counter-reset")
        set(value) = component.setStyle("counter-reset", value)

    var counterSet: String
        get() = component.getStyle("counter-set")
        set(value) = component.setStyle("counter-set", value)

    var cursor: String
        get() = component.getStyle("cursor")
        set(value) = component.setStyle("cursor", value)

    var dominantBaseline: String
        get() = component.getStyle("dominant-baseline")
        set(value) = component.setStyle("dominant-baseline", value)

    var emptyCells: String
        get() = component.getStyle("empty-cells")
        set(value) = component.setStyle("empty-cells", value)

    var filter: String
        get() = component.getStyle("filter")
        set(value) = component.setStyle("filter", value)

    var floodColor: String
        get() = component.getStyle("flood-color")
        set(value) = component.setStyle("flood-color", value)

    var floodOpacity: String
        get() = component.getStyle("flood-opacity")
        set(value) = component.setStyle("flood-opacity", value)

    var flowFrom: String
        get() = component.getStyle("flow-from")
        set(value) = component.setStyle("flow-from", value)

    var flowInto: String
        get() = component.getStyle("flow-into")
        set(value) = component.setStyle("flow-into", value)

    var font: String
        get() = component.getStyle("font")
        set(value) = component.setStyle("font", value)

    var fontFamily: String
        get() = component.getStyle("font-family")
        set(value) = component.setStyle("font-family", value)

    var fontFeatureSettings: String
        get() = component.getStyle("font-feature-settings")
        set(value) = component.setStyle("font-feature-settings", value)

    var fontKerning: String
        get() = component.getStyle("font-kerning")
        set(value) = component.setStyle("font-kerning", value)

    var fontLanguageOverride: String
        get() = component.getStyle("font-language-override")
        set(value) = component.setStyle("font-language-override", value)

    var fontOpticalSizing: String
        get() = component.getStyle("font-optical-sizing")
        set(value) = component.setStyle("font-optical-sizing", value)

    var fontPalette: String
        get() = component.getStyle("font-palette")
        set(value) = component.setStyle("font-palette", value)

    var fontSize: String
        get() = component.getStyle("font-size")
        set(value) = component.setStyle("font-size", value)

    var fontSizeAdjust: String
        get() = component.getStyle("font-size-adjust")
        set(value) = component.setStyle("font-size-adjust", value)

    var fontStyle: String
        get() = component.getStyle("font-style")
        set(value) = component.setStyle("font-style", value)

    var fontSynthesis: String
        get() = component.getStyle("font-synthesis")
        set(value) = component.setStyle("font-synthesis", value)

    var fontSynthesisPosition: String
        get() = component.getStyle("font-synthesis-position")
        set(value) = component.setStyle("font-synthesis-position", value)

    var fontSynthesisSmallCaps: String
        get() = component.getStyle("font-synthesis-small-caps")
        set(value) = component.setStyle("font-synthesis-small-caps", value)

    var fontSynthesisStyle: String
        get() = component.getStyle("font-synthesis-style")
        set(value) = component.setStyle("font-synthesis-style", value)

    var fontSynthesisWeight: String
        get() = component.getStyle("font-synthesis-weight")
        set(value) = component.setStyle("font-synthesis-weight", value)

    var fontVariant: String
        get() = component.getStyle("font-variant")
        set(value) = component.setStyle("font-variant", value)

    var fontVariantAlternates: String
        get() = component.getStyle("font-variant-alternates")
        set(value) = component.setStyle("font-variant-alternates", value)

    var fontVariantCaps: String
        get() = component.getStyle("font-variant-caps")
        set(value) = component.setStyle("font-variant-caps", value)

    var fontVariantEastAsian: String
        get() = component.getStyle("font-variant-east-asian")
        set(value) = component.setStyle("font-variant-east-asian", value)

    var fontVariantEmoji: String
        get() = component.getStyle("font-variant-emoji")
        set(value) = component.setStyle("font-variant-emoji", value)

    var fontVariantLigatures: String
        get() = component.getStyle("font-variant-ligatures")
        set(value) = component.setStyle("font-variant-ligatures", value)

    var fontVariantNumeric: String
        get() = component.getStyle("font-variant-numeric")
        set(value) = component.setStyle("font-variant-numeric", value)

    var fontVariantPosition: String
        get() = component.getStyle("font-variant-position")
        set(value) = component.setStyle("font-variant-position", value)

    var fontVariationSettings: String
        get() = component.getStyle("font-variation-settings")
        set(value) = component.setStyle("font-variation-settings", value)

    var fontWeight: String
        get() = component.getStyle("font-weight")
        set(value) = component.setStyle("font-weight", value)

    var fontWidth: String
        get() = component.getStyle("font-width")
        set(value) = component.setStyle("font-width", value)

    var footnoteDisplay: String
        get() = component.getStyle("footnote-display")
        set(value) = component.setStyle("footnote-display", value)

    var footnotePolicy: String
        get() = component.getStyle("footnote-policy")
        set(value) = component.setStyle("footnote-policy", value)

    var gap: String
        get() = component.getStyle("gap")
        set(value) = component.setStyle("gap", value)

    var gridAutoFlow: String
        get() = component.getStyle("grid-auto-flow")
        set(value) = component.setStyle("grid-auto-flow", value)

    var hangingPunctuation: String
        get() = component.getStyle("hanging-punctuation")
        set(value) = component.setStyle("hanging-punctuation", value)

    var height: String
        get() = component.getStyle("height")
        set(value) = component.setStyle("height", value)

    var hyphenateCharacter: String
        get() = component.getStyle("hyphenate-character")
        set(value) = component.setStyle("hyphenate-character", value)

    var hyphenateLimitChars: String
        get() = component.getStyle("hyphenate-limit-chars")
        set(value) = component.setStyle("hyphenate-limit-chars", value)

    var hyphenateLimitLast: String
        get() = component.getStyle("hyphenate-limit-last")
        set(value) = component.setStyle("hyphenate-limit-last", value)

    var hyphenateLimitLines: String
        get() = component.getStyle("hyphenate-limit-lines")
        set(value) = component.setStyle("hyphenate-limit-lines", value)

    var hyphenateLimitZone: String
        get() = component.getStyle("hyphenate-limit-zone")
        set(value) = component.setStyle("hyphenate-limit-zone", value)

    var hyphens: String
        get() = component.getStyle("hyphens")
        set(value) = component.setStyle("hyphens", value)

    var imageResolution: String
        get() = component.getStyle("image-resolution")
        set(value) = component.setStyle("image-resolution", value)

    var initialLetter: String
        get() = component.getStyle("initial-letter")
        set(value) = component.setStyle("initial-letter", value)

    var initialLetterAlign: String
        get() = component.getStyle("initial-letter-align")
        set(value) = component.setStyle("initial-letter-align", value)

    var initialLetterWrap: String
        get() = component.getStyle("initial-letter-wrap")
        set(value) = component.setStyle("initial-letter-wrap", value)

    var inlineSize: String
        get() = component.getStyle("inline-size")
        set(value) = component.setStyle("inline-size", value)

    var inlineSizing: String
        get() = component.getStyle("inline-sizing")
        set(value) = component.setStyle("inline-sizing", value)

    var inset: Int
        get() = component.getStyle("inset").toInt()
        set(value) = component.setStyle("inset", "$value")

    var insetBlock: String
        get() = component.getStyle("inset-block")
        set(value) = component.setStyle("inset-block", value)

    var insetBlockEnd: String
        get() = component.getStyle("inset-block-end")
        set(value) = component.setStyle("inset-block-end", value)

    var insetBlockStart: String
        get() = component.getStyle("inset-block-start")
        set(value) = component.setStyle("inset-block-start", value)

    var insetInline: String
        get() = component.getStyle("inset-inline")
        set(value) = component.setStyle("inset-inline", value)

    var insetInlineEnd: String
        get() = component.getStyle("inset-inline-end")
        set(value) = component.setStyle("inset-inline-end", value)

    var insetInlineStart: String
        get() = component.getStyle("inset-inline-start")
        set(value) = component.setStyle("inset-inline-start", value)

    var interpolateSize: String
        get() = component.getStyle("interpolate-size")
        set(value) = component.setStyle("interpolate-size", value)

    var justifyContent: String
        get() = component.getStyle("justify-content")
        set(value) = component.setStyle("justify-content", value)

    var justifyItems: String
        get() = component.getStyle("justify-items")
        set(value) = component.setStyle("justify-items", value)

    var justifySelf: String
        get() = component.getStyle("justify-self")
        set(value) = component.setStyle("justify-self", value)

    var left: String
        get() = component.getStyle("left")
        set(value) = component.setStyle("left", value)

    var letterSpacing: String
        get() = component.getStyle("letter-spacing")
        set(value) = component.setStyle("letter-spacing", value)

    var lightingColor: String
        get() = component.getStyle("lighting-color")
        set(value) = component.setStyle("lighting-color", value)

    var lineBreak: String
        get() = component.getStyle("line-break")
        set(value) = component.setStyle("line-break", value)

    var lineClamp: String
        get() = component.getStyle("line-clamp")
        set(value) = component.setStyle("line-clamp", value)

    var lineFitEdge: String
        get() = component.getStyle("line-fit-edge")
        set(value) = component.setStyle("line-fit-edge", value)

    var lineGrid: String
        get() = component.getStyle("line-grid")
        set(value) = component.setStyle("line-grid", value)

    var lineHeight: String
        get() = component.getStyle("line-height")
        set(value) = component.setStyle("line-height", value)

    var linePadding: String
        get() = component.getStyle("line-padding")
        set(value) = component.setStyle("line-padding", value)

    var lineSnap: String
        get() = component.getStyle("line-snap")
        set(value) = component.setStyle("line-snap", value)

    var listStyle: String
        get() = component.getStyle("list-style")
        set(value) = component.setStyle("list-style", value)

    var listStyleImage: String
        get() = component.getStyle("list-style-image")
        set(value) = component.setStyle("list-style-image", value)

    var listStylePosition: String
        get() = component.getStyle("list-style-position")
        set(value) = component.setStyle("list-style-position", value)

    var listStyleType: String
        get() = component.getStyle("list-style-type")
        set(value) = component.setStyle("list-style-type", value)

    var margin: String
        get() = component.getStyle("margin")
        set(value) = component.setStyle("margin", value)

    var marginBlock: String
        get() = component.getStyle("margin-block")
        set(value) = component.setStyle("margin-block", value)

    var marginBlockEnd: String
        get() = component.getStyle("margin-block-end")
        set(value) = component.setStyle("margin-block-end", value)

    var marginBlockStart: String
        get() = component.getStyle("margin-block-start")
        set(value) = component.setStyle("margin-block-start", value)

    var marginBottom: String
        get() = component.getStyle("margin-bottom")
        set(value) = component.setStyle("margin-bottom", value)

    var marginInline: String
        get() = component.getStyle("margin-inline")
        set(value) = component.setStyle("margin-inline", value)

    var marginInlineEnd: String
        get() = component.getStyle("margin-inline-end")
        set(value) = component.setStyle("margin-inline-end", value)

    var marginInlineStart: String
        get() = component.getStyle("margin-inline-start")
        set(value) = component.setStyle("margin-inline-start", value)

    var marginLeft: String
        get() = component.getStyle("margin-left")
        set(value) = component.setStyle("margin-left", value)

    var marginRight: String
        get() = component.getStyle("margin-right")
        set(value) = component.setStyle("margin-right", value)

    var marginTop: String
        get() = component.getStyle("margin-top")
        set(value) = component.setStyle("margin-top", value)

    var marginTrim: String
        get() = component.getStyle("margin-trim")
        set(value) = component.setStyle("margin-trim", value)

    var markerSide: String
        get() = component.getStyle("marker-side")
        set(value) = component.setStyle("marker-side", value)

    var masonry: String
        get() = component.getStyle("masonry")
        set(value) = component.setStyle("masonry", value)

    var masonryAutoTracks: String
        get() = component.getStyle("masonry-auto-tracks")
        set(value) = component.setStyle("masonry-auto-tracks", value)

    var masonryDirection: String
        get() = component.getStyle("masonry-direction")
        set(value) = component.setStyle("masonry-direction", value)

    var masonryFill: String
        get() = component.getStyle("masonry-fill")
        set(value) = component.setStyle("masonry-fill", value)

    var masonryFlow: String
        get() = component.getStyle("masonry-flow")
        set(value) = component.setStyle("masonry-flow", value)

    var masonrySlack: String
        get() = component.getStyle("masonry-slack")
        set(value) = component.setStyle("masonry-slack", value)

    var masonryTemplateAreas: String
        get() = component.getStyle("masonry-template-areas")
        set(value) = component.setStyle("masonry-template-areas", value)
    var masonryTemplateTracks: String
        get() = component.getStyle("masonry-template-tracks")
        set(value) = component.setStyle("masonry-template-tracks", value)

    var maxBlockSize: String
        get() = component.getStyle("max-block-size")
        set(value) = component.setStyle("max-block-size", value)

    var maxHeight: String
        get() = component.getStyle("max-height")
        set(value) = component.setStyle("max-height", value)

    var maxInlineSize: String
        get() = component.getStyle("max-inline-size")
        set(value) = component.setStyle("max-inline-size", value)

    var maxLines: String
        get() = component.getStyle("max-lines")
        set(value) = component.setStyle("max-lines", value)

    var maxWidth: String
        get() = component.getStyle("max-width")
        set(value) = component.setStyle("max-width", value)

    var minBlockSize: String
        get() = component.getStyle("min-block-size")
        set(value) = component.setStyle("min-block-size", value)

    var minHeight: String
        get() = component.getStyle("min-height")
        set(value) = component.setStyle("min-height", value)

    var minInlineSize: String
        get() = component.getStyle("min-inline-size")
        set(value) = component.setStyle("min-inline-size", value)

    var minIntrinsicSizing: String
        get() = component.getStyle("min-intrinsic-sizing")
        set(value) = component.setStyle("min-intrinsic-sizing", value)

    var minWidth: String
        get() = component.getStyle("min-width")
        set(value) = component.setStyle("min-width", value)

    var navDown: String
        get() = component.getStyle("nav-down")
        set(value) = component.setStyle("nav-down", value)

    var navLeft: String
        get() = component.getStyle("nav-left")
        set(value) = component.setStyle("nav-left", value)

    var navRight: String
        get() = component.getStyle("nav-right")
        set(value) = component.setStyle("nav-right", value)

    var navUp: String
        get() = component.getStyle("nav-up")
        set(value) = component.setStyle("nav-up", value)

    var objectFit: String
        get() = component.getStyle("object-fit")
        set(value) = component.setStyle("object-fit", value)

    var offset: String
        get() = component.getStyle("offset")
        set(value) = component.setStyle("offset", value)

    var offsetAnchor: String
        get() = component.getStyle("offset-anchor")
        set(value) = component.setStyle("offset-anchor", value)

    var offsetDistance: String
        get() = component.getStyle("offset-distance")
        set(value) = component.setStyle("offset-distance", value)

    var offsetPath: String
        get() = component.getStyle("offset-path")
        set(value) = component.setStyle("offset-path", value)

    var offsetPosition: String
        get() = component.getStyle("offset-position")
        set(value) = component.setStyle("offset-position", value)

    var offsetRotate: String
        get() = component.getStyle("offset-rotate")
        set(value) = component.setStyle("offset-rotate", value)

    var outline: String
        get() = component.getStyle("outline")
        set(value) = component.setStyle("outline", value)

    var outlineColor: String
        get() = component.getStyle("outline-color")
        set(value) = component.setStyle("outline-color", value)

    var outlineOffset: String
        get() = component.getStyle("outline-offset")
        set(value) = component.setStyle("outline-offset", value)

    var outlineStyle: String
        get() = component.getStyle("outline-style")
        set(value) = component.setStyle("outline-style", value)

    var outlineWidth: String
        get() = component.getStyle("outline-width")
        set(value) = component.setStyle("outline-width", value)

    var overflow: String
        get() = component.getStyle("overflow")
        set(value) = component.setStyle("overflow", value)

    var overflowAnchor: String
        get() = component.getStyle("overflow-anchor")
        set(value) = component.setStyle("overflow-anchor", value)

    var overflowBlock: String
        get() = component.getStyle("overflow-block")
        set(value) = component.setStyle("overflow-block", value)

    var overflowClipMargin: String
        get() = component.getStyle("overflow-clip-margin")
        set(value) = component.setStyle("overflow-clip-margin", value)

    var overflowClipMarginBlock: String
        get() = component.getStyle("overflow-clip-margin-block")
        set(value) = component.setStyle("overflow-clip-margin-block", value)

    var overflowClipMarginBlockEnd: String
        get() = component.getStyle("overflow-clip-margin-block-end")
        set(value) = component.setStyle("overflow-clip-margin-block-end", value)

    var overflowClipMarginBlockStart: String
        get() = component.getStyle("overflow-clip-margin-block-start")
        set(value) = component.setStyle("overflow-clip-margin-block-start", value)

    var overflowClipMarginBottom: String
        get() = component.getStyle("overflow-clip-margin-bottom")
        set(value) = component.setStyle("overflow-clip-margin-bottom", value)

    var overflowClipMarginInline: String
        get() = component.getStyle("overflow-clip-margin-inline")
        set(value) = component.setStyle("overflow-clip-margin-inline", value)

    var overflowClipMarginInlineEnd: String
        get() = component.getStyle("overflow-clip-margin-inline-end")
        set(value) = component.setStyle("overflow-clip-margin-inline-end", value)

    var overflowClipMarginInlineStart: String
        get() = component.getStyle("overflow-clip-margin-inline-start")
        set(value) = component.setStyle("overflow-clip-margin-inline-start", value)

    var overflowClipMarginLeft: String
        get() = component.getStyle("overflow-clip-margin-left")
        set(value) = component.setStyle("overflow-clip-margin-left", value)

    var overflowClipMarginRight: String
        get() = component.getStyle("overflow-clip-margin-right")
        set(value) = component.setStyle("overflow-clip-margin-right", value)

    var overflowClipMarginTop: String
        get() = component.getStyle("overflow-clip-margin-top")
        set(value) = component.setStyle("overflow-clip-margin-top", value)

    var overflowInline: String
        get() = component.getStyle("overflow-inline")
        set(value) = component.setStyle("overflow-inline", value)

    var overflowWrap: String
        get() = component.getStyle("overflow-wrap")
        set(value) = component.setStyle("overflow-wrap", value)

    var overflowX: String
        get() = component.getStyle("overflow-x")
        set(value) = component.setStyle("overflow-x", value)

    var overflowY: String
        get() = component.getStyle("overflow-y")
        set(value) = component.setStyle("overflow-y", value)

    var padding: String
        get() = component.getStyle("padding")
        set(value) = component.setStyle("padding", value)

    var paddingBlock: String
        get() = component.getStyle("padding-block")
        set(value) = component.setStyle("padding-block", value)

    var paddingBlockEnd: String
        get() = component.getStyle("padding-block-end")
        set(value) = component.setStyle("padding-block-end", value)

    var paddingBlockStart: String
        get() = component.getStyle("padding-block-start")
        set(value) = component.setStyle("padding-block-start", value)

    var paddingBottom: String
        get() = component.getStyle("padding-bottom")
        set(value) = component.setStyle("padding-bottom", value)

    var paddingInline: String
        get() = component.getStyle("padding-inline")
        set(value) = component.setStyle("padding-inline", value)

    var paddingInlineEnd: String
        get() = component.getStyle("padding-inline-end")
        set(value) = component.setStyle("padding-inline-end", value)

    var paddingInlineStart: String
        get() = component.getStyle("padding-inline-start")
        set(value) = component.setStyle("padding-inline-start", value)

    var paddingLeft: String
        get() = component.getStyle("padding-left")
        set(value) = component.setStyle("padding-left", value)

    var paddingRight: String
        get() = component.getStyle("padding-right")
        set(value) = component.setStyle("padding-right", value)

    var paddingTop: String
        get() = component.getStyle("padding-top")
        set(value) = component.setStyle("padding-top", value)

    var page: String
        get() = component.getStyle("page")
        set(value) = component.setStyle("page", value)

    var perspective: String
        get() = component.getStyle("perspective")
        set(value) = component.setStyle("perspective", value)

    var perspectiveOrigin: String
        get() = component.getStyle("perspective-origin")
        set(value) = component.setStyle("perspective-origin", value)

    var placeContent: String
        get() = component.getStyle("place-content")
        set(value) = component.setStyle("place-content", value)

    var placeItems: String
        get() = component.getStyle("place-items")
        set(value) = component.setStyle("place-items", value)

    var placeSelf: String
        get() = component.getStyle("place-self")
        set(value) = component.setStyle("place-self", value)

    var position: String
        get() = component.getStyle("position")
        set(value) = component.setStyle("position", value)

    var positionAnchor: String
        get() = component.getStyle("position-anchor")
        set(value) = component.setStyle("position-anchor", value)

    var positionArea: String
        get() = component.getStyle("position-area")
        set(value) = component.setStyle("position-area", value)

    var positionTry: String
        get() = component.getStyle("position-try")
        set(value) = component.setStyle("position-try", value)

    var positionTryFallbacks: String
        get() = component.getStyle("position-try-fallbacks")
        set(value) = component.setStyle("position-try-fallbacks", value)

    var positionTryOrder: String
        get() = component.getStyle("position-try-order")
        set(value) = component.setStyle("position-try-order", value)

    var positionVisibility: String
        get() = component.getStyle("position-visibility")
        set(value) = component.setStyle("position-visibility", value)

    var quotes: String
        get() = component.getStyle("quotes")
        set(value) = component.setStyle("quotes", value)

    var regionFragment: String
        get() = component.getStyle("region-fragment")
        set(value) = component.setStyle("region-fragment", value)

    var resize: String
        get() = component.getStyle("resize")
        set(value) = component.setStyle("resize", value)

    var right: String
        get() = component.getStyle("right")
        set(value) = component.setStyle("right", value)

    var rotate: String
        get() = component.getStyle("rotate")
        set(value) = component.setStyle("rotate", value)

    var rowGap: String
        get() = component.getStyle("row-gap")
        set(value) = component.setStyle("row-gap", value)

    var rubyAlign: String
        get() = component.getStyle("ruby-align")
        set(value) = component.setStyle("ruby-align", value)

    var rubyMerge: String
        get() = component.getStyle("ruby-merge")
        set(value) = component.setStyle("ruby-merge", value)

    var rubyOverhang: String
        get() = component.getStyle("ruby-overhang")
        set(value) = component.setStyle("ruby-overhang", value)

    var rubyPosition: String
        get() = component.getStyle("ruby-position")
        set(value) = component.setStyle("ruby-position", value)

    var running: String
        get() = component.getStyle("running")
        set(value) = component.setStyle("running", value)

    var scale: String
        get() = component.getStyle("scale")
        set(value) = component.setStyle("scale", value)

    var scrollBehavior: String
        get() = component.getStyle("scroll-behavior")
        set(value) = component.setStyle("scroll-behavior", value)

    var scrollTimeline: String
        get() = component.getStyle("scroll-timeline")
        set(value) = component.setStyle("scroll-timeline", value)

    var scrollTimelineAxis: String
        get() = component.getStyle("scroll-timeline-axis")
        set(value) = component.setStyle("scroll-timeline-axis", value)

    var scrollTimelineName: String
        get() = component.getStyle("scroll-timeline-name")
        set(value) = component.setStyle("scroll-timeline-name", value)

    var scrollbarGutter: String
        get() = component.getStyle("scrollbar-gutter")
        set(value) = component.setStyle("scrollbar-gutter", value)

    var shapeInside: String
        get() = component.getStyle("shape-inside")
        set(value) = component.setStyle("shape-inside", value)

    var spatialNavigationAction: String
        get() = component.getStyle("spatial-navigation-action")
        set(value) = component.setStyle("spatial-navigation-action", value)

    var spatialNavigationContain: String
        get() = component.getStyle("spatial-navigation-contain")
        set(value) = component.setStyle("spatial-navigation-contain", value)

    var spatialNavigationFunction: String
        get() = component.getStyle("spatial-navigation-function")
        set(value) = component.setStyle("spatial-navigation-function", value)

    var stringSet: String
        get() = component.getStyle("string-set")
        set(value) = component.setStyle("string-set", value)

    var tabSize: String
        get() = component.getStyle("tab-size")
        set(value) = component.setStyle("tab-size", value)

    var tableLayout: String
        get() = component.getStyle("table-layout")
        set(value) = component.setStyle("table-layout", value)

    var textAlign: String
        get() = component.getStyle("text-align")
        set(value) = component.setStyle("text-align", value)

    var textAlignAll: String
        get() = component.getStyle("text-align-all")
        set(value) = component.setStyle("text-align-all", value)

    var textAlignLast: String
        get() = component.getStyle("text-align-last")
        set(value) = component.setStyle("text-align-last", value)

    var textAutospace: String
        get() = component.getStyle("text-autospace")
        set(value) = component.setStyle("text-autospace", value)

    var textBox: String
        get() = component.getStyle("text-box")
        set(value) = component.setStyle("text-box", value)

    var textBoxEdge: String
        get() = component.getStyle("text-box-edge")
        set(value) = component.setStyle("text-box-edge", value)

    var textBoxTrim: String
        get() = component.getStyle("text-box-trim")
        set(value) = component.setStyle("text-box-trim", value)

    var textDecoration: String
        get() = component.getStyle("text-decoration")
        set(value) = component.setStyle("text-decoration", value)

    var textDecorationColor: String
        get() = component.getStyle("text-decoration-color")
        set(value) = component.setStyle("text-decoration-color", value)

    var textDecorationLine: String
        get() = component.getStyle("text-decoration-line")
        set(value) = component.setStyle("text-decoration-line", value)

    var textDecorationSkip: String
        get() = component.getStyle("text-decoration-skip")
        set(value) = component.setStyle("text-decoration-skip", value)

    var textDecorationSkipBox: String
        get() = component.getStyle("text-decoration-skip-box")
        set(value) = component.setStyle("text-decoration-skip-box", value)

    var textDecorationSkipInk: String
        get() = component.getStyle("text-decoration-skip-ink")
        set(value) = component.setStyle("text-decoration-skip-ink", value)

    var textDecorationSkipInset: String
        get() = component.getStyle("text-decoration-skip-inset")
        set(value) = component.setStyle("text-decoration-skip-inset", value)

    var textDecorationSkipSelf: String
        get() = component.getStyle("text-decoration-skip-self")
        set(value) = component.setStyle("text-decoration-skip-self", value)

    var textDecorationSkipSpaces: String
        get() = component.getStyle("text-decoration-skip-spaces")
        set(value) = component.setStyle("text-decoration-skip-spaces", value)

    var textDecorationStyle: String
        get() = component.getStyle("text-decoration-style")
        set(value) = component.setStyle("text-decoration-style", value)

    var textDecorationThickness: String
        get() = component.getStyle("text-decoration-thickness")
        set(value) = component.setStyle("text-decoration-thickness", value)

    var textEmphasis: String
        get() = component.getStyle("text-emphasis")
        set(value) = component.setStyle("text-emphasis", value)

    var textEmphasisColor: String
        get() = component.getStyle("text-emphasis-color")
        set(value) = component.setStyle("text-emphasis-color", value)

    var textEmphasisPosition: String
        get() = component.getStyle("text-emphasis-position")
        set(value) = component.setStyle("text-emphasis-position", value)

    var textEmphasisSkip: String
        get() = component.getStyle("text-emphasis-skip")
        set(value) = component.setStyle("text-emphasis-skip", value)

    var textEmphasisStyle: String
        get() = component.getStyle("text-emphasis-style")
        set(value) = component.setStyle("text-emphasis-style", value)

    var textGroupAlign: String
        get() = component.getStyle("text-group-align")
        set(value) = component.setStyle("text-group-align", value)

    var textIndent: String
        get() = component.getStyle("text-indent")
        set(value) = component.setStyle("text-indent", value)

    var textJustify: String
        get() = component.getStyle("text-justify")
        set(value) = component.setStyle("text-justify", value)

    var textOverflow: String
        get() = component.getStyle("text-overflow")
        set(value) = component.setStyle("text-overflow", value)

    var textShadow: String
        get() = component.getStyle("text-shadow")
        set(value) = component.setStyle("text-shadow", value)

    var textSpacing: String
        get() = component.getStyle("text-spacing")
        set(value) = component.setStyle("text-spacing", value)

    var textSpacingTrim: String
        get() = component.getStyle("text-spacing-trim")
        set(value) = component.setStyle("text-spacing-trim", value)

    var textTransform: String
        get() = component.getStyle("text-transform")
        set(value) = component.setStyle("text-transform", value)

    var textUnderlineOffset: String
        get() = component.getStyle("text-underline-offset")
        set(value) = component.setStyle("text-underline-offset", value)

    var textUnderlinePosition: String
        get() = component.getStyle("text-underline-position")
        set(value) = component.setStyle("text-underline-position", value)

    var textWrap: String
        get() = component.getStyle("text-wrap")
        set(value) = component.setStyle("text-wrap", value)

    var textWrapMode: String
        get() = component.getStyle("text-wrap-mode")
        set(value) = component.setStyle("text-wrap-mode", value)

    var textWrapStyle: String
        get() = component.getStyle("text-wrap-style")
        set(value) = component.setStyle("text-wrap-style", value)

    var timelineScope: String
        get() = component.getStyle("timeline-scope")
        set(value) = component.setStyle("timeline-scope", value)

    var top: String
        get() = component.getStyle("top")
        set(value) = component.setStyle("top", value)

    var transformStyle: String
        get() = component.getStyle("transform-style")
        set(value) = component.setStyle("transform-style", value)

    var transition: String
        get() = component.getStyle("transition")
        set(value) = component.setStyle("transition", value)

    var transitionDelay: String
        get() = component.getStyle("transition-delay")
        set(value) = component.setStyle("transition-delay", value)

    var transitionDuration: String
        get() = component.getStyle("transition-duration")
        set(value) = component.setStyle("transition-duration", value)

    var transitionProperty: String
        get() = component.getStyle("transition-property")
        set(value) = component.setStyle("transition-property", value)

    var transitionTimingFunction: String
        get() = component.getStyle("transition-timing-function")
        set(value) = component.setStyle("transition-timing-function", value)

    var translate: String
        get() = component.getStyle("translate")
        set(value) = component.setStyle("translate", value)

    var userSelect: String
        get() = component.getStyle("user-select")
        set(value) = component.setStyle("user-select", value)

    var verticalAlign: String
        get() = component.getStyle("vertical-align")
        set(value) = component.setStyle("vertical-align", value)

    var viewTimeline: String
        get() = component.getStyle("view-timeline")
        set(value) = component.setStyle("view-timeline", value)

    var viewTimelineAxis: String
        get() = component.getStyle("view-timeline-axis")
        set(value) = component.setStyle("view-timeline-axis", value)

    var viewTimelineInset: String
        get() = component.getStyle("view-timeline-inset")
        set(value) = component.setStyle("view-timeline-inset", value)

    var viewTimelineName: String
        get() = component.getStyle("view-timeline-name")
        set(value) = component.setStyle("view-timeline-name", value)

    var viewTransitionClass: String
        get() = component.getStyle("view-transition-class")
        set(value) = component.setStyle("view-transition-class", value)

    var viewTransitionGroup: String
        get() = component.getStyle("view-transition-group")
        set(value) = component.setStyle("view-transition-group", value)

    var whiteSpace: String
        get() = component.getStyle("white-space")
        set(value) = component.setStyle("white-space", value)

    var whiteSpaceCollapse: String
        get() = component.getStyle("white-space-collapse")
        set(value) = component.setStyle("white-space-collapse", value)

    var whiteSpaceTrim: String
        get() = component.getStyle("white-space-trim")
        set(value) = component.setStyle("white-space-trim", value)

    var width: String
        get() = component.getStyle("width")
        set(value) = component.setStyle("width", value)

    var wordBreak: String
        get() = component.getStyle("word-break")
        set(value) = component.setStyle("word-break", value)

    var wordSpaceTransform: String
        get() = component.getStyle("word-space-transform")
        set(value) = component.setStyle("word-space-transform", value)

    var wordSpacing: String
        get() = component.getStyle("word-spacing")
        set(value) = component.setStyle("word-spacing", value)

    var wordWrap: String
        get() = component.getStyle("word-wrap")
        set(value) = component.setStyle("word-wrap", value)

    var wrapAfter: String
        get() = component.getStyle("wrap-after")
        set(value) = component.setStyle("wrap-after", value)

    var wrapBefore: String
        get() = component.getStyle("wrap-before")
        set(value) = component.setStyle("wrap-before", value)

    var wrapFlow: String
        get() = component.getStyle("wrap-flow")
        set(value) = component.setStyle("wrap-flow", value)

    var wrapInside: String
        get() = component.getStyle("wrap-inside")
        set(value) = component.setStyle("wrap-inside", value)

    var wrapThrough: String
        get() = component.getStyle("wrap-through")
        set(value) = component.setStyle("wrap-through", value)

    // --- Missing CSS Properties (Added) ---

    // A

    var all: String
        get() = component.getStyle("all")
        set(value) = component.setStyle("all", value)

    // B

    var background: String
        get() = component.getStyle("background")
        set(value) = component.setStyle("background", value)

    var backgroundAttachment: String
        get() = component.getStyle("background-attachment")
        set(value) = component.setStyle("background-attachment", value)

    var backgroundBlendMode: String
        get() = component.getStyle("background-blend-mode")
        set(value) = component.setStyle("background-blend-mode", value)

    var backgroundClip: String
        get() = component.getStyle("background-clip")
        set(value) = component.setStyle("background-clip", value)

    var backgroundImage: String
        get() = component.getStyle("background-image")
        set(value) = component.setStyle("background-image", value)

    var backgroundOrigin: String
        get() = component.getStyle("background-origin")
        set(value) = component.setStyle("background-origin", value)

    var backgroundPosition: String
        get() = component.getStyle("background-position")
        set(value) = component.setStyle("background-position", value)

    var backgroundPositionX: String
        get() = component.getStyle("background-position-x")
        set(value) = component.setStyle("background-position-x", value)

    var backgroundPositionY: String
        get() = component.getStyle("background-position-y")
        set(value) = component.setStyle("background-position-y", value)

    var backgroundRepeat: String
        get() = component.getStyle("background-repeat")
        set(value) = component.setStyle("background-repeat", value)

    var backgroundSize: String
        get() = component.getStyle("background-size")
        set(value) = component.setStyle("background-size", value)

    var border: String
        get() = component.getStyle("border")
        set(value) = component.setStyle("border", value)

    var borderColor: String
        get() = component.getStyle("border-color")
        set(value) = component.setStyle("border-color", value)

    var borderStyle: String
        get() = component.getStyle("border-style")
        set(value) = component.setStyle("border-style", value)

    var borderWidth: String
        get() = component.getStyle("border-width")
        set(value) = component.setStyle("border-width", value)

    var borderBottom: String
        get() = component.getStyle("border-bottom")
        set(value) = component.setStyle("border-bottom", value)

    var borderBottomColor: String
        get() = component.getStyle("border-bottom-color")
        set(value) = component.setStyle("border-bottom-color", value)

    var borderBottomLeftRadius: String
        get() = component.getStyle("border-bottom-left-radius")
        set(value) = component.setStyle("border-bottom-left-radius", value)

    var borderBottomRightRadius: String
        get() = component.getStyle("border-bottom-right-radius")
        set(value) = component.setStyle("border-bottom-right-radius", value)

    var borderBottomStyle: String
        get() = component.getStyle("border-bottom-style")
        set(value) = component.setStyle("border-bottom-style", value)

    var borderBottomWidth: String
        get() = component.getStyle("border-bottom-width")
        set(value) = component.setStyle("border-bottom-width", value)

    var borderLeft: String
        get() = component.getStyle("border-left")
        set(value) = component.setStyle("border-left", value)

    var borderLeftColor: String
        get() = component.getStyle("border-left-color")
        set(value) = component.setStyle("border-left-color", value)

    var borderLeftStyle: String
        get() = component.getStyle("border-left-style")
        set(value) = component.setStyle("border-left-style", value)

    var borderLeftWidth: String
        get() = component.getStyle("border-left-width")
        set(value) = component.setStyle("border-left-width", value)

    var borderRight: String
        get() = component.getStyle("border-right")
        set(value) = component.setStyle("border-right", value)

    var borderRightColor: String
        get() = component.getStyle("border-right-color")
        set(value) = component.setStyle("border-right-color", value)

    var borderRightStyle: String
        get() = component.getStyle("border-right-style")
        set(value) = component.setStyle("border-right-style", value)

    var borderRightWidth: String
        get() = component.getStyle("border-right-width")
        set(value) = component.setStyle("border-right-width", value)

    var borderTop: String
        get() = component.getStyle("border-top")
        set(value) = component.setStyle("border-top", value)

    var borderTopColor: String
        get() = component.getStyle("border-top-color")
        set(value) = component.setStyle("border-top-color", value)

    var borderTopLeftRadius: String
        get() = component.getStyle("border-top-left-radius")
        set(value) = component.setStyle("border-top-left-radius", value)

    var borderTopRightRadius: String
        get() = component.getStyle("border-top-right-radius")
        set(value) = component.setStyle("border-top-right-radius", value)

    var borderTopStyle: String
        get() = component.getStyle("border-top-style")
        set(value) = component.setStyle("border-top-style", value)

    var borderTopWidth: String
        get() = component.getStyle("border-top-width")
        set(value) = component.setStyle("border-top-width", value)

    var boxDecorationBreak: String
        get() = component.getStyle("box-decoration-break")
        set(value) = component.setStyle("box-decoration-break", value)

    var boxShadow: String
        get() = component.getStyle("box-shadow")
        set(value) = component.setStyle("box-shadow", value)

    // C

    var clear: String
        get() = component.getStyle("clear")
        set(value) = component.setStyle("clear", value)

    var clip: String
        get() = component.getStyle("clip")
        set(value) = component.setStyle("clip", value)

    var clipPath: String
        get() = component.getStyle("clip-path")
        set(value) = component.setStyle("clip-path", value)

    var colorScheme: String
        get() = component.getStyle("color-scheme")
        set(value) = component.setStyle("color-scheme", value)

    var columnCount: String
        get() = component.getStyle("column-count")
        set(value) = component.setStyle("column-count", value)

    var columnFill: String
        get() = component.getStyle("column-fill")
        set(value) = component.setStyle("column-fill", value)

    var columnRule: String
        get() = component.getStyle("column-rule")
        set(value) = component.setStyle("column-rule", value)

    var columnRuleColor: String
        get() = component.getStyle("column-rule-color")
        set(value) = component.setStyle("column-rule-color", value)

    var columnRuleStyle: String
        get() = component.getStyle("column-rule-style")
        set(value) = component.setStyle("column-rule-style", value)

    var columnRuleWidth: String
        get() = component.getStyle("column-rule-width")
        set(value) = component.setStyle("column-rule-width", value)

    var columnSpan: String
        get() = component.getStyle("column-span")
        set(value) = component.setStyle("column-span", value)

    var columnWidth: String
        get() = component.getStyle("column-width")
        set(value) = component.setStyle("column-width", value)

    var columns: String
        get() = component.getStyle("columns")
        set(value) = component.setStyle("columns", value)

    // D, E, F

    var direction: String
        get() = component.getStyle("direction")
        set(value) = component.setStyle("direction", value)

    var flex: String
        get() = component.getStyle("flex")
        set(value) = component.setStyle("flex", value)

    var flexBasis: String
        get() = component.getStyle("flex-basis")
        set(value) = component.setStyle("flex-basis", value)

    var flexDirection: String
        get() = component.getStyle("flex-direction")
        set(value) = component.setStyle("flex-direction", value)

    var flexFlow: String
        get() = component.getStyle("flex-flow")
        set(value) = component.setStyle("flex-flow", value)

    var flexGrow: String
        get() = component.getStyle("flex-grow")
        set(value) = component.setStyle("flex-grow", value)

    var flexShrink: String
        get() = component.getStyle("flex-shrink")
        set(value) = component.setStyle("flex-shrink", value)

    var flexWrap: String
        get() = component.getStyle("flex-wrap")
        set(value) = component.setStyle("flex-wrap", value)

    var float: String
        get() = component.getStyle("float")
        set(value) = component.setStyle("float", value)

    // G, H, I, J, K, L, M

    var grid: String
        get() = component.getStyle("grid")
        set(value) = component.setStyle("grid", value)

    var gridArea: String
        get() = component.getStyle("grid-area")
        set(value) = component.setStyle("grid-area", value)

    var gridAutoColumns: String
        get() = component.getStyle("grid-auto-columns")
        set(value) = component.setStyle("grid-auto-columns", value)

    var gridAutoRows: String
        get() = component.getStyle("grid-auto-rows")
        set(value) = component.setStyle("grid-auto-rows", value)

    var gridColumn: String
        get() = component.getStyle("grid-column")
        set(value) = component.setStyle("grid-column", value)

    var gridColumnEnd: String
        get() = component.getStyle("grid-column-end")
        set(value) = component.setStyle("grid-column-end", value)

    var gridColumnGap: String
        get() = component.getStyle("grid-column-gap")
        set(value) = component.setStyle("grid-column-gap", value)

    var gridColumnStart: String
        get() = component.getStyle("grid-column-start")
        set(value) = component.setStyle("grid-column-start", value)

    var gridGap: String
        get() = component.getStyle("grid-gap")
        set(value) = component.setStyle("grid-gap", value)

    var gridRow: String
        get() = component.getStyle("grid-row")
        set(value) = component.setStyle("grid-row", value)

    var gridRowEnd: String
        get() = component.getStyle("grid-row-end")
        set(value) = component.setStyle("grid-row-end", value)

    var gridRowGap: String
        get() = component.getStyle("grid-row-gap")
        set(value) = component.setStyle("grid-row-gap", value)

    var gridRowStart: String
        get() = component.getStyle("grid-row-start")
        set(value) = component.setStyle("grid-row-start", value)

    var gridTemplate: String
        get() = component.getStyle("grid-template")
        set(value) = component.setStyle("grid-template", value)

    var gridTemplateAreas: String
        get() = component.getStyle("grid-template-areas")
        set(value) = component.setStyle("grid-template-areas", value)

    var gridTemplateColumns: String
        get() = component.getStyle("grid-template-columns")
        set(value) = component.setStyle("grid-template-columns", value)

    var gridTemplateRows: String
        get() = component.getStyle("grid-template-rows")
        set(value) = component.setStyle("grid-template-rows", value)

    // I (continued)

    var isolation: String
        get() = component.getStyle("isolation")
        set(value) = component.setStyle("isolation", value)

    // M (continued)

    var mixBlendMode: String
        get() = component.getStyle("mix-blend-mode")
        set(value) = component.setStyle("mix-blend-mode", value)

    // O

    var objectPosition: String
        get() = component.getStyle("object-position")
        set(value) = component.setStyle("object-position", value)

    var opacity: String
        get() = component.getStyle("opacity")
        set(value) = component.setStyle("opacity", value)

    var order: String
        get() = component.getStyle("order")
        set(value) = component.setStyle("order", value)

    var orphans: String
        get() = component.getStyle("orphans")
        set(value) = component.setStyle("orphans", value)

    // P, Q, R, S

    var pointerEvents: String
        get() = component.getStyle("pointer-events")
        set(value) = component.setStyle("pointer-events", value)

    // S (continued)

    var scrollMargin: String
        get() = component.getStyle("scroll-margin")
        set(value) = component.setStyle("scroll-margin", value)

    var scrollMarginBlock: String
        get() = component.getStyle("scroll-margin-block")
        set(value) = component.setStyle("scroll-margin-block", value)

    var scrollMarginBlockEnd: String
        get() = component.getStyle("scroll-margin-block-end")
        set(value) = component.setStyle("scroll-margin-block-end", value)

    var scrollMarginBlockStart: String
        get() = component.getStyle("scroll-margin-block-start")
        set(value) = component.setStyle("scroll-margin-block-start", value)

    var scrollMarginBottom: String
        get() = component.getStyle("scroll-margin-bottom")
        set(value) = component.setStyle("scroll-margin-bottom", value)

    var scrollMarginInline: String
        get() = component.getStyle("scroll-margin-inline")
        set(value) = component.setStyle("scroll-margin-inline", value)

    var scrollMarginInlineEnd: String
        get() = component.getStyle("scroll-margin-inline-end")
        set(value) = component.setStyle("scroll-margin-inline-end", value)

    var scrollMarginInlineStart: String
        get() = component.getStyle("scroll-margin-inline-start")
        set(value) = component.setStyle("scroll-margin-inline-start", value)

    var scrollMarginLeft: String
        get() = component.getStyle("scroll-margin-left")
        set(value) = component.setStyle("scroll-margin-left", value)

    var scrollMarginRight: String
        get() = component.getStyle("scroll-margin-right")
        set(value) = component.setStyle("scroll-margin-right", value)

    var scrollMarginTop: String
        get() = component.getStyle("scroll-margin-top")
        set(value) = component.setStyle("scroll-margin-top", value)

    var scrollPadding: String
        get() = component.getStyle("scroll-padding")
        set(value) = component.setStyle("scroll-padding", value)

    var scrollPaddingBlock: String
        get() = component.getStyle("scroll-padding-block")
        set(value) = component.setStyle("scroll-padding-block", value)

    var scrollPaddingBlockEnd: String
        get() = component.getStyle("scroll-padding-block-end")
        set(value) = component.setStyle("scroll-padding-block-end", value)

    var scrollPaddingBlockStart: String
        get() = component.getStyle("scroll-padding-block-start")
        set(value) = component.setStyle("scroll-padding-block-start", value)

    var scrollPaddingBottom: String
        get() = component.getStyle("scroll-padding-bottom")
        set(value) = component.setStyle("scroll-padding-bottom", value)

    var scrollPaddingInline: String
        get() = component.getStyle("scroll-padding-inline")
        set(value) = component.setStyle("scroll-padding-inline", value)

    var scrollPaddingInlineEnd: String
        get() = component.getStyle("scroll-padding-inline-end")
        set(value) = component.setStyle("scroll-padding-inline-end", value)

    var scrollPaddingInlineStart: String
        get() = component.getStyle("scroll-padding-inline-start")
        set(value) = component.setStyle("scroll-padding-inline-start", value)

    var scrollPaddingLeft: String
        get() = component.getStyle("scroll-padding-left")
        set(value) = component.setStyle("scroll-padding-left", value)

    var scrollPaddingRight: String
        get() = component.getStyle("scroll-padding-right")
        set(value) = component.setStyle("scroll-padding-right", value)

    var scrollPaddingTop: String
        get() = component.getStyle("scroll-padding-top")
        set(value) = component.setStyle("scroll-padding-top", value)

    var scrollSnapAlign: String
        get() = component.getStyle("scroll-snap-align")
        set(value) = component.setStyle("scroll-snap-align", value)

    var scrollSnapStop: String
        get() = component.getStyle("scroll-snap-stop")
        set(value) = component.setStyle("scroll-snap-stop", value)

    var scrollSnapType: String
        get() = component.getStyle("scroll-snap-type")
        set(value) = component.setStyle("scroll-snap-type", value)

    var shapeImageThreshold: String
        get() = component.getStyle("shape-image-threshold")
        set(value) = component.setStyle("shape-image-threshold", value)

    var shapeMargin: String
        get() = component.getStyle("shape-margin")
        set(value) = component.setStyle("shape-margin", value)

    var shapeOutside: String
        get() = component.getStyle("shape-outside")
        set(value) = component.setStyle("shape-outside", value)

    // T, U, V, W, X, Y, Z

    var touchAction: String
        get() = component.getStyle("touch-action")
        set(value) = component.setStyle("touch-action", value)

    var transform: String
        get() = component.getStyle("transform")
        set(value) = component.setStyle("transform", value)

    var transformBox: String
        get() = component.getStyle("transform-box")
        set(value) = component.setStyle("transform-box", value)

    var transformOrigin: String
        get() = component.getStyle("transform-origin")
        set(value) = component.setStyle("transform-origin", value)

    var unicodeBidi: String
        get() = component.getStyle("unicode-bidi")
        set(value) = component.setStyle("unicode-bidi", value)

    var userZoom: String
        get() = component.getStyle("user-zoom")
        set(value) = component.setStyle("user-zoom", value)

    var vectorEffect: String
        get() = component.getStyle("vector-effect")
        set(value) = component.setStyle("vector-effect", value)

    var visibility: String
        get() = component.getStyle("visibility")
        set(value) = component.setStyle("visibility", value)

    var willChange: String
        get() = component.getStyle("will-change")
        set(value) = component.setStyle("will-change", value)

    var widows: String
        get() = component.getStyle("widows")
        set(value) = component.setStyle("widows", value)

    // -webkit- prefixed properties (examples, add more if needed)

    var webkitAppearance: String
        get() = component.getStyle("-webkit-appearance")
        set(value) = component.setStyle("-webkit-appearance", value)

    var webkitBorderBefore: String
        get() = component.getStyle("-webkit-border-before")
        set(value) = component.setStyle("-webkit-border-before", value)

    var webkitBorderBeforeColor: String
        get() = component.getStyle("-webkit-border-before-color")
        set(value) = component.setStyle("-webkit-border-before-color", value)

    var webkitBorderBeforeStyle: String
        get() = component.getStyle("-webkit-border-before-style")
        set(value) = component.setStyle("-webkit-border-before-style", value)

    var webkitBorderBeforeWidth: String
        get() = component.getStyle("-webkit-border-before-width")
        set(value) = component.setStyle("-webkit-border-before-width", value)

    var webkitBoxReflect: String
        get() = component.getStyle("-webkit-box-reflect")
        set(value) = component.setStyle("-webkit-box-reflect", value)

    var webkitFilter: String
        get() = component.getStyle("-webkit-filter")
        set(value) = component.setStyle("-webkit-filter", value)

    var webkitMask: String
        get() = component.getStyle("-webkit-mask")
        set(value) = component.setStyle("-webkit-mask", value)

    var webkitMaskClip: String
        get() = component.getStyle("-webkit-mask-clip")
        set(value) = component.setStyle("-webkit-mask-clip", value)

    var webkitMaskComposite: String
        get() = component.getStyle("-webkit-mask-composite")
        set(value) = component.setStyle("-webkit-mask-composite", value)

    var webkitMaskImage: String
        get() = component.getStyle("-webkit-mask-image")
        set(value) = component.setStyle("-webkit-mask-image", value)

    var webkitMaskOrigin: String
        get() = component.getStyle("-webkit-mask-origin")
        set(value) = component.setStyle("-webkit-mask-origin", value)

    var webkitMaskPosition: String
        get() = component.getStyle("-webkit-mask-position")
        set(value) = component.setStyle("-webkit-mask-position", value)

    var webkitMaskPositionX: String
        get() = component.getStyle("-webkit-mask-position-x")
        set(value) = component.setStyle("-webkit-mask-position-x", value)

    var webkitMaskPositionY: String
        get() = component.getStyle("-webkit-mask-position-y")
        set(value) = component.setStyle("-webkit-mask-position-y", value)

    var webkitMaskRepeat: String
        get() = component.getStyle("-webkit-mask-repeat")
        set(value) = component.setStyle("-webkit-mask-repeat", value)

    var webkitMaskRepeatX: String
        get() = component.getStyle("-webkit-mask-repeat-x")
        set(value) = component.setStyle("-webkit-mask-repeat-x", value)

    var webkitMaskRepeatY: String
        get() = component.getStyle("-webkit-mask-repeat-y")
        set(value) = component.setStyle("-webkit-mask-repeat-y", value)

    var webkitMaskSize: String
        get() = component.getStyle("-webkit-mask-size")
        set(value) = component.setStyle("-webkit-mask-size", value)

    var webkitOverflowScrolling: String
        get() = component.getStyle("-webkit-overflow-scrolling")
        set(value) = component.setStyle("-webkit-overflow-scrolling", value)

    var webkitTapHighlightColor: String
        get() = component.getStyle("-webkit-tap-highlight-color")
        set(value) = component.setStyle("-webkit-tap-highlight-color", value)

    var webkitTextFillColor: String
        get() = component.getStyle("-webkit-text-fill-color")
        set(value) = component.setStyle("-webkit-text-fill-color", value)

    var webkitTextSizeAdjust: String
        get() = component.getStyle("-webkit-text-size-adjust")
        set(value) = component.setStyle("-webkit-text-size-adjust", value)

    var webkitTextStroke: String
        get() = component.getStyle("-webkit-text-stroke")
        set(value) = component.setStyle("-webkit-text-stroke", value)

    var webkitTextStrokeColor: String
        get() = component.getStyle("-webkit-text-stroke-color")
        set(value) = component.setStyle("-webkit-text-stroke-color", value)

    var webkitTextStrokeWidth: String
        get() = component.getStyle("-webkit-text-stroke-width")
        set(value) = component.setStyle("-webkit-text-stroke-width", value)

    var webkitTouchCallout: String
        get() = component.getStyle("-webkit-touch-callout")
        set(value) = component.setStyle("-webkit-touch-callout", value)

    var webkitUserModify: String
        get() = component.getStyle("-webkit-user-modify")
        set(value) = component.setStyle("-webkit-user-modify", value)

    // -moz- prefixed properties (examples)

    var mozAppearance: String
        get() = component.getStyle("-moz-appearance")
        set(value) = component.setStyle("-moz-appearance", value)

    var mozBinding: String
        get() = component.getStyle("-moz-binding")
        set(value) = component.setStyle("-moz-binding", value)

    var mozBorderBottomColors: String
        get() = component.getStyle("-moz-border-bottom-colors")
        set(value) = component.setStyle("-moz-border-bottom-colors", value)

    var mozBorderLeftColors: String
        get() = component.getStyle("-moz-border-left-colors")
        set(value) = component.setStyle("-moz-border-left-colors", value)

    var mozBorderRightColors: String
        get() = component.getStyle("-moz-border-right-colors")
        set(value) = component.setStyle("-moz-border-right-colors", value)

    var mozBorderTopColors: String
        get() = component.getStyle("-moz-border-top-colors")
        set(value) = component.setStyle("-moz-border-top-colors", value)

    var mozContextProperties: String
        get() = component.getStyle("-moz-context-properties")
        set(value) = component.setStyle("-moz-context-properties", value)

    var mozFloatEdge: String
        get() = component.getStyle("-moz-float-edge")
        set(value) = component.setStyle("-moz-float-edge", value)

    var mozForceBrokenImageIcon: String
        get() = component.getStyle("-moz-force-broken-image-icon")
        set(value) = component.setStyle("-moz-force-broken-image-icon", value)

    var mozImageRegion: String
        get() = component.getStyle("-moz-image-region")
        set(value) = component.setStyle("-moz-image-region", value)

    var mozOrient: String
        get() = component.getStyle("-moz-orient")
        set(value) = component.setStyle("-moz-orient", value)

    var mozStackSizing: String
        get() = component.getStyle("-moz-stack-sizing")
        set(value) = component.setStyle("-moz-stack-sizing", value)

    var mozTextBlink: String
        get() = component.getStyle("-moz-text-blink")
        set(value) = component.setStyle("-moz-text-blink", value)

    var mozUserFocus: String
        get() = component.getStyle("-moz-user-focus")
        set(value) = component.setStyle("-moz-user-focus", value)

    var mozUserInput: String
        get() = component.getStyle("-moz-user-input")
        set(value) = component.setStyle("-moz-user-input", value)

    var mozUserModify: String
        get() = component.getStyle("-moz-user-modify")
        set(value) = component.setStyle("-moz-user-modify", value)

    var mozWindowDragging: String
        get() = component.getStyle("-moz-window-dragging")
        set(value) = component.setStyle("-moz-window-dragging", value)

    var mozWindowShadow: String
        get() = component.getStyle("-moz-window-shadow")
        set(value) = component.setStyle("-moz-window-shadow", value)

    // -ms- prefixed properties (examples)

    var msAccelerator: String
        get() = component.getStyle("-ms-accelerator")
        set(value) = component.setStyle("-ms-accelerator", value)

    var msBlockProgression: String
        get() = component.getStyle("-ms-block-progression")
        set(value) = component.setStyle("-ms-block-progression", value)

    var msContentZoomChaining: String
        get() = component.getStyle("-ms-content-zoom-chaining")
        set(value) = component.setStyle("-ms-content-zoom-chaining", value)

    var msContentZoomLimit: String
        get() = component.getStyle("-ms-content-zoom-limit")
        set(value) = component.setStyle("-ms-content-zoom-limit", value)

    var msContentZoomLimitMax: String
        get() = component.getStyle("-ms-content-zoom-limit-max")
        set(value) = component.setStyle("-ms-content-zoom-limit-max", value)

    var msContentZoomLimitMin: String
        get() = component.getStyle("-ms-content-zoom-limit-min")
        set(value) = component.setStyle("-ms-content-zoom-limit-min", value)

    var msContentZoomSnap: String
        get() = component.getStyle("-ms-content-zoom-snap")
        set(value) = component.setStyle("-ms-content-zoom-snap", value)

    var msContentZoomSnapPoints: String
        get() = component.getStyle("-ms-content-zoom-snap-points")
        set(value) = component.setStyle("-ms-content-zoom-snap-points", value)

    var msContentZoomSnapType: String
        get() = component.getStyle("-ms-content-zoom-snap-type")
        set(value) = component.setStyle("-ms-content-zoom-snap-type", value)

    var msContentZooming: String
        get() = component.getStyle("-ms-content-zooming")
        set(value) = component.setStyle("-ms-content-zooming", value)

    var msFilter: String
        get() = component.getStyle("-ms-filter")
        set(value) = component.setStyle("-ms-filter", value)

    var msFlowFrom: String
        get() = component.getStyle("-ms-flow-from")
        set(value) = component.setStyle("-ms-flow-from", value)

    var msFlowInto: String
        get() = component.getStyle("-ms-flow-into")
        set(value) = component.setStyle("-ms-flow-into", value)

    var msGridColumns: String
        get() = component.getStyle("-ms-grid-columns")
        set(value) = component.setStyle("-ms-grid-columns", value)

    var msGridRows: String
        get() = component.getStyle("-ms-grid-rows")
        set(value) = component.setStyle("-ms-grid-rows", value)

    var msHighContrastAdjust: String
        get() = component.getStyle("-ms-high-contrast-adjust")
        set(value) = component.setStyle("-ms-high-contrast-adjust", value)

    var msHyphenateLimitChars: String
        get() = component.getStyle("-ms-hyphenate-limit-chars")
        set(value) = component.setStyle("-ms-hyphenate-limit-chars", value)

    var msHyphenateLimitLines: String
        get() = component.getStyle("-ms-hyphenate-limit-lines")
        set(value) = component.setStyle("-ms-hyphenate-limit-lines", value)

    var msHyphenateLimitZone: String
        get() = component.getStyle("-ms-hyphenate-limit-zone")
        set(value) = component.setStyle("-ms-hyphenate-limit-zone", value)

    var msImeAlign: String
        get() = component.getStyle("-ms-ime-align")
        set(value) = component.setStyle("-ms-ime-align", value)

    var msOverflowStyle: String
        get() = component.getStyle("-ms-overflow-style")
        set(value) = component.setStyle("-ms-overflow-style", value)

    var msScrollChaining: String
        get() = component.getStyle("-ms-scroll-chaining")
        set(value) = component.setStyle("-ms-scroll-chaining", value)

    var msScrollLimit: String
        get() = component.getStyle("-ms-scroll-limit")
        set(value) = component.setStyle("-ms-scroll-limit", value)

    var msScrollLimitXMax: String
        get() = component.getStyle("-ms-scroll-limit-x-max")
        set(value) = component.setStyle("-ms-scroll-limit-x-max", value)

    var msScrollLimitXMin: String
        get() = component.getStyle("-ms-scroll-limit-x-min")
        set(value) = component.setStyle("-ms-scroll-limit-x-min", value)

    var msScrollLimitYMax: String
        get() = component.getStyle("-ms-scroll-limit-y-max")
        set(value) = component.setStyle("-ms-scroll-limit-y-max", value)

    var msScrollLimitYMin: String
        get() = component.getStyle("-ms-scroll-limit-y-min")
        set(value) = component.setStyle("-ms-scroll-limit-y-min", value)

    var msScrollRails: String
        get() = component.getStyle("-ms-scroll-rails")
        set(value) = component.setStyle("-ms-scroll-rails", value)

    var msScrollSnapPointsX: String
        get() = component.getStyle("-ms-scroll-snap-points-x")
        set(value) = component.setStyle("-ms-scroll-snap-points-x", value)

    var msScrollSnapPointsY: String
        get() = component.getStyle("-ms-scroll-snap-points-y")
        set(value) = component.setStyle("-ms-scroll-snap-points-y", value)

    var msScrollSnapType: String
        get() = component.getStyle("-ms-scroll-snap-type")
        set(value) = component.setStyle("-ms-scroll-snap-type", value)

    var msScrollSnapX: String
        get() = component.getStyle("-ms-scroll-snap-x")
        set(value) = component.setStyle("-ms-scroll-snap-x", value)

    var msScrollSnapY: String
        get() = component.getStyle("-ms-scroll-snap-y")
        set(value) = component.setStyle("-ms-scroll-snap-y", value)

    var msScrollTranslation: String
        get() = component.getStyle("-ms-scroll-translation")
        set(value) = component.setStyle("-ms-scroll-translation", value)

    var msScrollbarArrowColor: String
        get() = component.getStyle("-ms-scrollbar-arrow-color")
        set(value) = component.setStyle("-ms-scrollbar-arrow-color", value)

    var msScrollbarBaseColor: String
        get() = component.getStyle("-ms-scrollbar-base-color")
        set(value) = component.setStyle("-ms-scrollbar-base-color", value)

    var msScrollbarDarkshadowColor: String
        get() = component.getStyle("-ms-scrollbar-darkshadow-color")
        set(value) = component.setStyle("-ms-scrollbar-darkshadow-color", value)

    var msScrollbarFaceColor: String
        get() = component.getStyle("-ms-scrollbar-face-color")
        set(value) = component.setStyle("-ms-scrollbar-face-color", value)

    var msScrollbarHighlightColor: String
        get() = component.getStyle("-ms-scrollbar-highlight-color")
        set(value) = component.setStyle("-ms-scrollbar-highlight-color", value)

    var msScrollbarShadowColor: String
        get() = component.getStyle("-ms-scrollbar-shadow-color")
        set(value) = component.setStyle("-ms-scrollbar-shadow-color", value)

    var msScrollbarTrackColor: String
        get() = component.getStyle("-ms-scrollbar-track-color")
        set(value) = component.setStyle("-ms-scrollbar-track-color", value)

    var msTextAutospace: String
        get() = component.getStyle("-ms-text-autospace")
        set(value) = component.setStyle("-ms-text-autospace", value)

    var msTouchSelect: String
        get() = component.getStyle("-ms-touch-select")
        set(value) = component.setStyle("-ms-touch-select", value)

    var msUserSelect: String
        get() = component.getStyle("-ms-user-select")
        set(value) = component.setStyle("-ms-user-select", value)

    var msWrapFlow: String
        get() = component.getStyle("-ms-wrap-flow")
        set(value) = component.setStyle("-ms-wrap-flow", value)

    var msWrapMargin: String
        get() = component.getStyle("-ms-wrap-margin")
        set(value) = component.setStyle("-ms-wrap-margin", value)

    var msWrapThrough: String
        get() = component.getStyle("-ms-wrap-through")
        set(value) = component.setStyle("-ms-wrap-through", value)

}