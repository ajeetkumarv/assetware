package com.assetware.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Triplet;

import com.assetware.beans.Asset;
import com.assetware.beans.Change;
import com.assetware.utils.AppUtils;

public class ChangeDetector {

	private final Asset curr;
	private List<Asset> hist;
	
	public ChangeDetector(List<Asset> hist, Asset curr) {
		this.curr = curr;
		this.hist = hist;
	}
	
	public List<Change> extractChanges() {
		List<Change> changeLog = new ArrayList<>();

		if (hist.isEmpty()) {
			return changeLog;
		}
		
		Asset latest = curr;
		
		for(Asset asset : hist) {
			String by = asset.getUpdatedBy();
			String on = AppUtils.toString(asset.getUpdatedOn());
			
			Change c = new Change(by, on);
			c.setChanges(diffData(asset, latest));
			c.setId(asset.getUpdatedOn().format(DateTimeFormatter.ofPattern("addMMyyyyhhmmss")));
			changeLog.add(c);
			
			latest = asset;
		}
		
		return changeLog;
	}
	
	private List<Triplet<String, String, String>> diffData(Asset old, Asset latest) {
		
		List<Triplet<String, String, String>> changes = new ArrayList<>();
		
		diffAssetType(old, latest, changes);
		diffAssetStatus(old, latest, changes);
		diffTag(old, latest, changes);
		diffMake(old, latest, changes);
		diffModel(old, latest, changes);
		diffStoreCode(old, latest, changes);
		diffMemory(old, latest, changes);
		diffHardDisk(old, latest, changes);
		diffOs(old, latest, changes);
		diffPoNo(old, latest, changes);
		diffPoDate(old, latest, changes);
		diffInvNo(old, latest, changes);
		diffInvDate(old, latest, changes);
		diffRemark(old, latest, changes);
		
		return changes;
	}
	
	private void diffAssetType(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Type", old.getAssetType(), latest.getAssetType());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	
	private void diffAssetStatus(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Status", old.getAssetStatus(), latest.getAssetStatus());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffTag(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Tag", old.getTag(), latest.getTag());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffMake(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Make", old.getMake(), latest.getMake());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffModel(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Model", old.getModel(), latest.getModel());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffStoreCode(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Store code", old.getStoreCode(), latest.getStoreCode());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffMemory(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Memory", old.getMemory(), latest.getMemory());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffHardDisk(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Hard disk", old.getHardDisk(), latest.getHardDisk());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffOs(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("OS", old.getOs(), latest.getOs());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffPoNo(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("PO No", old.getPoNo(), latest.getPoNo());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffPoDate(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("PO Date", old.getPoDate(), latest.getPoDate());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffInvNo(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Invoice No", old.getInvoiceNo(), latest.getInvoiceNo());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffInvDate(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Invoice Date", old.getInvoiceDate(), latest.getInvoiceDate());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	private void diffRemark(Asset old, Asset latest, List<Triplet<String, String, String>> changes) {
		Triplet<String, String, String> diff = findDiff("Remark", old.getRemark(), latest.getRemark());
		
		if (diff != null) {
			changes.add(diff);
		}
	}
	
	private Triplet<String, String, String> findDiff(String name, String from, String to) {
		if (bothNull(from, to)) return null;
		
		if (from == null || to == null || !from.equals(to)) {
			return Triplet.with(name, from, to);
		}
		
		return null;
	}
	private Triplet<String, String, String> findDiff(String name, LocalDate from, LocalDate to) {
		if (bothNull(from, to)) return null;
		String fromStr = null, toStr = null;
		
		if (from == null) {
			toStr = to.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			return Triplet.with(name, fromStr, toStr);
		}
		
		if (to == null) {
			fromStr = from.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			return Triplet.with(name, fromStr, toStr);
		}
		
		if (!from.equals(to)) {
			
			fromStr = from.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			toStr = to.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			
			return Triplet.with(name, fromStr, toStr);
		}
		
		return null;
	}
	
	private boolean oneNull(Object a, Object b) {
		return ( a == null && b != null ) || ( a != null && b == null );
	}
	
	private boolean bothNull(Object a, Object b) {
		return a == null && b == null;
	}
}
