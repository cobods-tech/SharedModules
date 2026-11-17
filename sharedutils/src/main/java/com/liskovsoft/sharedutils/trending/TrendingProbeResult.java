package com.liskovsoft.sharedutils.trending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * One bounded observation made by the CCTV trending-source diagnostic.
 *
 * This is diagnostic data only. It does not imply that a source is a valid
 * all-site ranking; callers must apply the probe acceptance criteria.
 */
public final class TrendingProbeResult {
    public enum PlaybackCheck {
        NOT_CHECKED,
        PLAYABLE,
        FAILED
    }

    private final String sourceId;
    private final String regionCode;
    private final long startedAtEpochMs;
    private final long durationMs;
    private final int httpStatus;
    private final int itemCount;
    private final int missingVideoIdCount;
    private final boolean rateLimited;
    private final boolean visitorDataPresent;
    private final List<String> videoIds;
    private final PlaybackCheck playbackCheck;
    private final String errorCategory;

    public TrendingProbeResult(
            String sourceId,
            String regionCode,
            long startedAtEpochMs,
            long durationMs,
            int httpStatus,
            int itemCount,
            int missingVideoIdCount,
            boolean rateLimited,
            boolean visitorDataPresent,
            List<String> videoIds,
            PlaybackCheck playbackCheck,
            String errorCategory) {
        this.sourceId = sourceId;
        this.regionCode = regionCode;
        this.startedAtEpochMs = startedAtEpochMs;
        this.durationMs = durationMs;
        this.httpStatus = httpStatus;
        this.itemCount = itemCount;
        this.missingVideoIdCount = missingVideoIdCount;
        this.rateLimited = rateLimited;
        this.visitorDataPresent = visitorDataPresent;
        this.videoIds = videoIds == null
                ? Collections.emptyList()
                : Collections.unmodifiableList(new ArrayList<>(videoIds));
        this.playbackCheck = playbackCheck == null
                ? PlaybackCheck.NOT_CHECKED
                : playbackCheck;
        this.errorCategory = errorCategory;
    }

    public String getSourceId() { return sourceId; }
    public String getRegionCode() { return regionCode; }
    public long getStartedAtEpochMs() { return startedAtEpochMs; }
    public long getDurationMs() { return durationMs; }
    public int getHttpStatus() { return httpStatus; }
    public int getItemCount() { return itemCount; }
    public int getMissingVideoIdCount() { return missingVideoIdCount; }
    public boolean isRateLimited() { return rateLimited; }
    public boolean isVisitorDataPresent() { return visitorDataPresent; }
    public List<String> getVideoIds() { return videoIds; }
    public PlaybackCheck getPlaybackCheck() { return playbackCheck; }
    public String getErrorCategory() { return errorCategory; }
}
